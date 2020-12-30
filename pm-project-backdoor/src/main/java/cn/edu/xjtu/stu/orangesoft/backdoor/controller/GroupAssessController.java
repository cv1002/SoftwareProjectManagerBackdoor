package cn.edu.xjtu.stu.orangesoft.backdoor.controller;

import cn.edu.xjtu.stu.orangesoft.backdoor.core.DIUtil;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Objects;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Operation;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.ResultInfo;
import cn.edu.xjtu.stu.orangesoft.backdoor.service.GroupAssessService;
import cn.edu.xjtu.stu.orangesoft.backdoor.service.RBACService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GroupAssessController {
    @Autowired
    GroupAssessService groupAssessService;
    @Autowired
    RBACService rbacService;
    @Autowired
    Gson gson;

    /**
     * 根据队伍ID，查询队伍成绩
     *
     * @param teamID       队伍ID
     * @param UserID       用户ID，用于RBAC
     * @param UserPassword 用户密码，用于RBAC
     * @return if (无评分 || 无权访问) return ResultInfo: {
     * "resultInfo": String
     * } else return GroupAssess: {
     * "TeamID": int,
     * "Score": int,
     * "TeamAssess": String,
     * "AssessorID": int
     * }
     */
    @GetMapping(value = "/groupAssess", produces = "application/json;charset=UTF-8")
    public String FindGroupScoreByTeamID(@RequestParam(name = "TeamID") Integer teamID,
                                         @CookieValue(value = "UserID", defaultValue = "0") Integer UserID,
                                         @CookieValue(value = "UserPassword", defaultValue = "") String UserPassword) {
        Operation operation = DIUtil.getBean(Operation.class);
        Objects objects = DIUtil.getBean(Objects.class);
        ResultInfo resultInfo = DIUtil.getBean(ResultInfo.class);
        operation.setOperationDescription("GET");
        objects.setObjectName("groupAssess");
        if (rbacService.CheckPermission(UserID, UserPassword, objects, operation)) {
            if (groupAssessService.FindGroupScoreByTeamID(teamID) == null) {
                resultInfo.setResultInfo("小组无评分！！");
                return gson.toJson(resultInfo);
            } else {
                return gson.toJson(groupAssessService.FindGroupScoreByTeamID(teamID));
            }
        } else {
            resultInfo.setResultInfo("无权访问！！");
            return gson.toJson(resultInfo);
        }
    }

    /**
     * 创建新的项目评价
     *
     * @param UserID       用户ID，用于RBAC
     * @param UserPassword 用户密码，用于RBAC
     * @param assess       评价内容
     * @param teamID       小组ID
     * @param score        小组成绩
     * @return ResultInfo: {
     * "resultInfo": String
     * }
     */
    @PostMapping(value = "/groupAssess", produces = "application/json;charset=UTF-8")
    public String BuildNewGroupAssess(@RequestParam(value = "UserID", defaultValue = "0") Integer UserID,
                                      @RequestParam(value = "UserPassword", defaultValue = "") String UserPassword,
                                      @RequestParam(name = "Assess") String assess,
                                      @RequestParam(name = "TeamID") Integer teamID,
                                      @RequestParam(name = "Score") Integer score) {
        Operation operation = DIUtil.getBean(Operation.class);
        Objects objects = DIUtil.getBean(Objects.class);
        ResultInfo resultInfo = DIUtil.getBean(ResultInfo.class);
        operation.setOperationDescription("POST");
        objects.setObjectName("groupAssess");
        if (rbacService.CheckPermission(UserID, UserPassword, objects, operation)) {
            resultInfo.setResultInfo(gson.toJson(groupAssessService.BuildNewGroupAssess(teamID, UserID, assess, score)));
        } else {
            resultInfo.setResultInfo("无权评价！！");
        }
        return gson.toJson(resultInfo);
    }
}

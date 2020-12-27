package cn.edu.xjtu.stu.orangesoft.backdoor.controller;

import cn.edu.xjtu.stu.orangesoft.backdoor.core.DIUtil;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Objects;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Operation;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.ResultInfo;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Team;
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

    @GetMapping(value = "/groupAccess", produces = "application/json;charset=UTF-8")
    public String FindGroupScoreBySTeamID(@RequestParam(name = "TeamID") Integer teamID,
                                          @CookieValue(value = "UserID", defaultValue = "0") Integer UserID,
                                          @CookieValue(value = "UserPassword", defaultValue = "") String UserPassword) {
        Operation operation = DIUtil.getBean(Operation.class);
        Objects objects = DIUtil.getBean(Objects.class);
        ResultInfo resultInfo = DIUtil.getBean(ResultInfo.class);
        operation.setOperationDescription("GET");
        objects.setObjectName("groupAssess");
        if (rbacService.CheckPermission(UserID, UserPassword, objects, operation)) {
            if (groupAssessService.FindGroupScoreBySTeamID(teamID) == null) {
                resultInfo.setResultInfo("小组无评分！！");
                return gson.toJson(resultInfo);
            } else {
                return gson.toJson(groupAssessService.FindGroupScoreBySTeamID(teamID));
            }
        } else {
            resultInfo.setResultInfo("无权访问！！");
            return gson.toJson(resultInfo);
        }
    }

    //Team team, Integer UserID, String Assess, Integer Score
    @PostMapping(value = "/groupAccess", produces = "application/json;charset=UTF-8")
    public String BuildNewGroupAssess(@RequestParam(value = "UserID", defaultValue = "0") Integer UserID,
                                      @RequestParam(value = "UserPassword", defaultValue = "") String UserPassword,
                                      @RequestParam(name = "Assess") String assess,
                                      @RequestParam(name = "Team") Team team,
                                      @RequestParam(name = "Score") Integer score) {
        Operation operation = DIUtil.getBean(Operation.class);
        Objects objects = DIUtil.getBean(Objects.class);
        ResultInfo resultInfo = DIUtil.getBean(ResultInfo.class);
        operation.setOperationDescription("POST");
        objects.setObjectName("groupAssess");
        if (rbacService.CheckPermission(UserID, UserPassword, objects, operation)) {
            resultInfo.setResultInfo(gson.toJson(groupAssessService.BuildNewGroupAssess(team, UserID, assess, score)));
        } else {
            resultInfo.setResultInfo("无权评价！！");
        }
        return gson.toJson(resultInfo);
    }
}

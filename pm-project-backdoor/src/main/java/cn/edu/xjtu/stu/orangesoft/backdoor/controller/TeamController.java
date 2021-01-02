package cn.edu.xjtu.stu.orangesoft.backdoor.controller;

import cn.edu.xjtu.stu.orangesoft.backdoor.core.DIUtil;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Objects;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Operation;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.ResultInfo;
import cn.edu.xjtu.stu.orangesoft.backdoor.service.RBACService;
import cn.edu.xjtu.stu.orangesoft.backdoor.service.TeamService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TeamController {
    @Autowired
    RBACService rbacService;
    @Autowired
    TeamService teamService;
    @Autowired
    Gson gson;

    @PostMapping(value = "/get/TeamMemberCount", produces = "application/json;charset=UTF-8")
    public String GetTeamMemberCount(@RequestParam("UserID") Integer UserID,
                                     @RequestParam("UserPassword") String UserPassword) {
        Objects objects = DIUtil.getBean(Objects.class);
        Operation operation = DIUtil.getBean(Operation.class);
        objects.setObjectName("team");
        operation.setOperationDescription("GET");

        if (rbacService.CheckPermission(UserID, UserPassword, objects, operation)) {
            return gson.toJson(teamService.GetTeamMemberCount(UserID));
        } else {
            ResultInfo resultInfo = DIUtil.getBean(ResultInfo.class);
            resultInfo.setResultInfo("无权访问！！");
            return gson.toJson(resultInfo);
        }
    }

    @PostMapping(value = "/get/TeamMemberList", produces = "application/json;charset=UTF-8")
    public String GetTeamMembers(@RequestParam("UserID") Integer UserID,
                                 @RequestParam("UserPassword") String UserPassword,
                                 @RequestParam("TeamID") Integer TeamID) {
        Objects objects = DIUtil.getBean(Objects.class);
        Operation operation = DIUtil.getBean(Operation.class);
        objects.setObjectName("team/teacher");
        operation.setOperationDescription("GET");

        if (rbacService.CheckPermission(UserID, UserPassword, objects, operation)) {
            return gson.toJson(teamService.GetTeamMembers(TeamID));
        } else {
            ResultInfo resultInfo = DIUtil.getBean(ResultInfo.class);
            resultInfo.setResultInfo("无权访问！！");
            return gson.toJson(resultInfo);
        }
    }

    @PostMapping(value = "/get/TeamMemberLists", produces = "application/json;charset=UTF-8")
    public String GetAllTeamMembers(@RequestParam("UserID") Integer UserID,
                                    @RequestParam("UserPassword") String UserPassword) {
        Objects objects = DIUtil.getBean(Objects.class);
        Operation operation = DIUtil.getBean(Operation.class);
        objects.setObjectName("team/teacher");
        operation.setOperationDescription("GET");
        if (rbacService.CheckPermission(UserID, UserPassword, objects, operation)) {
            //使用以下方法初始化的gson可以解码等号等符号，默认的gson等号会转成\u003d
            return new GsonBuilder().disableHtmlEscaping().create().toJson(teamService.GetAllTeamMembers());
        } else {
            ResultInfo resultInfo = DIUtil.getBean(ResultInfo.class);
            resultInfo.setResultInfo("无权访问！！");
            return gson.toJson(resultInfo);
        }
    }
}

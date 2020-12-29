package cn.edu.xjtu.stu.orangesoft.backdoor.controller;

import cn.edu.xjtu.stu.orangesoft.backdoor.core.DIUtil;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Objects;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Operation;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.ResultInfo;
import cn.edu.xjtu.stu.orangesoft.backdoor.service.ProjectService;
import cn.edu.xjtu.stu.orangesoft.backdoor.service.RBACService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProjectController {
    @Autowired
    ProjectService projectService;
    @Autowired
    RBACService rbacService;
    @Autowired
    Gson gson;

    @GetMapping(value = "/projects", produces = "application/json;charset=UTF-8")
    public String FindAllProjects(@CookieValue(value = "UserID", defaultValue = "0") String UserID,
                                  @CookieValue(value = "UserPassword", defaultValue = "") String UserPassword) {
        Operation operation = DIUtil.getBean(Operation.class);
        Objects objects = DIUtil.getBean(Objects.class);
        ResultInfo resultInfo = DIUtil.getBean(ResultInfo.class);
        operation.setOperationDescription("GET");
        objects.setObjectName("projects");
        if (rbacService.CheckPermission(Integer.parseInt(UserID), UserPassword, objects, operation)) {
            if (projectService.FindAllProjects().size() == 0) {
                resultInfo.setResultInfo("查不到项目！！");
                return gson.toJson(resultInfo);
            } else {
                return gson.toJson(projectService.FindAllProjects());
            }
        } else {
            resultInfo.setResultInfo("无权访问!!");
            return gson.toJson(resultInfo);
        }
    }

    @GetMapping(value = "/projectAssignment/", produces = "application/json;charset=UTF-8")
    public String FindTeamByProject(@RequestParam(name = "ProjectID") Integer ProjectID,
                                    @CookieValue(value = "UserID", defaultValue = "0") String UserID,
                                    @CookieValue(value = "UserPassword", defaultValue = "") String UserPassword) {
        Operation operation = DIUtil.getBean(Operation.class);
        Objects objects = DIUtil.getBean(Objects.class);
        ResultInfo resultInfo = DIUtil.getBean(ResultInfo.class);
        operation.setOperationDescription("GET");
        objects.setObjectName("project");
        if (rbacService.CheckPermission(Integer.parseInt(UserID), UserPassword, objects, operation)) {
            if (projectService.FindTeamByProject(ProjectID).size() == 0) {
                resultInfo.setResultInfo("没有选择该项目的小组！！");
                return gson.toJson(resultInfo);
            } else {
                return gson.toJson(projectService.FindTeamByProject(ProjectID));
            }
        } else {
            resultInfo.setResultInfo("无权访问!!");
            return gson.toJson(resultInfo);
        }
    }

    @GetMapping(value = "/project", produces = "application/json;charset=UTF-8")
    public String FindProjectByUser(@RequestParam(name = "UserID") Integer UserID,
                                    @CookieValue(value = "UserPassword", defaultValue = "") String UserPassword) {
        Operation operation = DIUtil.getBean(Operation.class);
        Objects objects = DIUtil.getBean(Objects.class);
        ResultInfo resultInfo = DIUtil.getBean(ResultInfo.class);
        operation.setOperationDescription("GET");
        objects.setObjectName("project");
        if (rbacService.CheckPermission(UserID, UserPassword, objects, operation)) {
            if (projectService.FindProjectByUser(UserID) == null) {
                resultInfo.setResultInfo("该用户不属于任何项目！！");
                return gson.toJson(resultInfo);
            } else {
                return gson.toJson(projectService.FindProjectByUser(UserID));
            }
        } else {
            resultInfo.setResultInfo("无权访问!!");
            return gson.toJson(resultInfo);
        }
    }

    @PostMapping(value = "/project", produces = "application/json;charset=UTF-8")
    public String BuildNewProject(@RequestParam(value = "UserID", defaultValue = "0") String UserID,
                                  @RequestParam(value = "UserPassword", defaultValue = "") String UserPassword,
                                  @RequestParam(name = "ProjectName") String ProjectName,
                                  @RequestParam(name = "Description") String Description) {
        Operation operation = DIUtil.getBean(Operation.class);
        Objects objects = DIUtil.getBean(Objects.class);
        ResultInfo resultInfo = DIUtil.getBean(ResultInfo.class);
        operation.setOperationDescription("POST");
        objects.setObjectName("project");
        if (rbacService.CheckPermission(Integer.parseInt(UserID), UserPassword, objects, operation)) {
            resultInfo.setResultInfo(gson.toJson(projectService.BuildNewProject(ProjectName, Description)));
        } else {
            resultInfo.setResultInfo("无权访问！！");
        }
        return gson.toJson(resultInfo);
    }

    @PostMapping(value = "/projectAssignment", produces = "application/json;charset=UTF-8")
    public String AssignProjectAssignment(@RequestParam(value = "UserID", defaultValue = "0") String UserID,
                                          @RequestParam(value = "UserPassword", defaultValue = "") String UserPassword,
                                          @RequestParam(value = "ProjectID") Integer ProjectID,
                                          @RequestParam(value = "TeamID") Integer TeamID,
                                          @RequestParam(value = "DeadLine") String DeadLine) {
        Operation operation = DIUtil.getBean(Operation.class);
        Objects objects = DIUtil.getBean(Objects.class);
        ResultInfo resultInfo = DIUtil.getBean(ResultInfo.class);
        operation.setOperationDescription("POST");
        objects.setObjectName("projectAssignment");

        if (rbacService.CheckPermission(Integer.parseInt(UserID), UserPassword, objects, operation)) {
            resultInfo.setResultInfo(gson.toJson(projectService.BuildNewProjectAssignment(ProjectID, TeamID, DeadLine)));
        } else {
            resultInfo.setResultInfo("无权访问！！");
        }
        return gson.toJson(resultInfo);
    }
}

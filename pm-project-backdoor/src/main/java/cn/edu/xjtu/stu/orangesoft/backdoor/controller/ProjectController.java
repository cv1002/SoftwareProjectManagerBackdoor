package cn.edu.xjtu.stu.orangesoft.backdoor.controller;

import cn.edu.xjtu.stu.orangesoft.backdoor.core.DIUtil;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Objects;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Operation;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.ResultInfo;
import cn.edu.xjtu.stu.orangesoft.backdoor.service.ProjectService;
import cn.edu.xjtu.stu.orangesoft.backdoor.service.RBACService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ProjectController {
    @Autowired
    ProjectService projectService;
    @Autowired
    RBACService rbacService;
    @Autowired
    Gson gson;

    /**
     * 获取所有的Project
     *
     * @param UserID       用户ID，用于RBAC
     * @param UserPassword 用户密码，用于RBAC
     * @return if (查不到项目 || 无权访问) return ResultInfo: {
     * "resultInfo": String
     * } else return {
     * List[Project]
     * }
     */
    @PostMapping(value = "/get/projects", produces = "application/json;charset=UTF-8")
    public String FindAllProjects(@RequestParam(value = "UserID") String UserID,
                                  @RequestParam(value = "UserPassword") String UserPassword) {
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

    /**
     * 根据项目ID查询小组
     *
     * @param ProjectID    项目ID
     * @param UserID       用户ID，用于RBAC
     * @param UserPassword 用户密码，用于RBAC
     * @return if (没有选择该项目的小组 || 无权访问) return ResultInfo: {
     * "resultInfo": String
     * } else return
     * List[ProjectAssignment]
     */
    @PostMapping(value = "/get/projectAssignment/", produces = "application/json;charset=UTF-8")
    public String FindTeamByProject(@RequestParam("ProjectID") Integer ProjectID,
                                    @RequestParam("UserID") String UserID,
                                    @RequestParam("UserPassword") String UserPassword) {
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

    /**
     * 通过用户名找到Project
     *
     * @param UserID       用户ID，用于RBAC
     * @param UserPassword 用户密码，用于RBAC
     * @return if (用户不属于任何项目 || 无权访问) return ResultInfo: {
     * "resultInfo": String
     * } else return Project: {
     * "ProjectID": String,
     * "ProjectName": String,
     * "ProjectDescription": String
     * }
     */
    @PostMapping(value = "/get/project", produces = "application/json;charset=UTF-8")
    public String FindProjectByUser(@RequestParam("UserID") Integer UserID,
                                    @RequestParam("UserPassword") String UserPassword) {
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

    /**
     * 创建新的Project
     *
     * @param UserID       用户ID，用于RBAC
     * @param UserPassword 用户密码，用于RBAC
     * @param ProjectName  项目名字
     * @param Description  项目描述
     * @return ResultInfo: {
     * "resultInfo": String
     * }
     */
    @PostMapping(value = "/project", produces = "application/json;charset=UTF-8")
    public String BuildNewProject(@RequestParam("UserID") String UserID,
                                  @RequestParam("UserPassword") String UserPassword,
                                  @RequestParam("ProjectName") String ProjectName,
                                  @RequestParam("Description") String Description) {
        Operation operation = DIUtil.getBean(Operation.class);
        Objects objects = DIUtil.getBean(Objects.class);
        ResultInfo resultInfo = DIUtil.getBean(ResultInfo.class);
        operation.setOperationDescription("POST");
        objects.setObjectName("project");
        if (rbacService.CheckPermission(Integer.parseInt(UserID), UserPassword, objects, operation)) {
            resultInfo.setResultInfo(projectService.BuildNewProject(ProjectName, Description).getResultInfo());
        } else {
            resultInfo.setResultInfo("无权访问！！");
        }
        return gson.toJson(resultInfo);
    }

    /**
     * 小组认领项目
     *
     * @param UserID       用户ID，用于RBAC
     * @param UserPassword 用户密码，用于RBAC
     * @param ProjectID    项目ID
     * @param TeamID       小组ID
     * @param DeadLine     项目的DeadLine
     * @return ResultInfo: {
     * "resultInfo": String
     * }
     */
    @PostMapping(value = "/projectAssignment", produces = "application/json;charset=UTF-8")
    public String AssignProjectAssignment(@RequestParam("UserID") String UserID,
                                          @RequestParam("UserPassword") String UserPassword,
                                          @RequestParam("ProjectID") Integer ProjectID,
                                          @RequestParam("TeamID") Integer TeamID,
                                          @RequestParam("DeadLine") String DeadLine) {
        Operation operation = DIUtil.getBean(Operation.class);
        Objects objects = DIUtil.getBean(Objects.class);
        ResultInfo resultInfo = DIUtil.getBean(ResultInfo.class);
        operation.setOperationDescription("POST");
        objects.setObjectName("projectAssignment");

        if (rbacService.CheckPermission(Integer.parseInt(UserID), UserPassword, objects, operation)) {
            resultInfo.setResultInfo(projectService.BuildNewProjectAssignment(ProjectID, TeamID, DeadLine).getResultInfo());
        } else {
            resultInfo.setResultInfo("无权访问！！");
        }
        return gson.toJson(resultInfo);
    }
}

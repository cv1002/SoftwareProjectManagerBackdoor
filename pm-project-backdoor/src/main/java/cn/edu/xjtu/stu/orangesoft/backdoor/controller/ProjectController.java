package cn.edu.xjtu.stu.orangesoft.backdoor.controller;

import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Object;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Operation;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.ProjectAssignmentResult;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Projects;
import cn.edu.xjtu.stu.orangesoft.backdoor.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController {
    @Autowired
    ProjectService projectService;
    @Autowired
    Operation operation;
    @Autowired
    Object object;

    @GetMapping(value = "/projects", produces = "application/json;charset=UTF-8")
    public List<Projects> FindAllProjects(@CookieValue(value = "UserID", defaultValue = "0") String UserID,
                                                    @CookieValue(value = "UserPassword", defaultValue = "") String UserPassword) {
        operation.setOperationDescription("GET");
        object.setObjectName("FindAllProjects");
        return projectService.FindAllProjects(Integer.parseInt(UserID), UserPassword, operation, object);
    }

    @GetMapping(value = "/projectAssignment/", produces = "application/json;charset=UTF-8")
    public List<ProjectAssignmentResult> FindTeamByProject(@RequestParam(name = "ProjectID") Integer ProjectID,
                                                                     @CookieValue(value = "UserID", defaultValue = "0") String UserID,
                                                                     @CookieValue(value = "UserPassword", defaultValue = "") String UserPassword) {
        operation.setOperationDescription("GET");
        object.setObjectName("FindTeamByProject");
        return projectService.FindTeamByProject(Integer.parseInt(UserID), UserPassword, operation, object, ProjectID);
    }
}

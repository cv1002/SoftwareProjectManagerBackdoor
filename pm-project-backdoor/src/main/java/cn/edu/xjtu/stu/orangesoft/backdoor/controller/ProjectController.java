package cn.edu.xjtu.stu.orangesoft.backdoor.controller;

import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.*;
import cn.edu.xjtu.stu.orangesoft.backdoor.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {
    @Autowired
    ProjectService projectService;
    @Autowired
    Operation operation;
    @Autowired
    Objects objects;

    @GetMapping(value = "/projects", produces = "application/json;charset=UTF-8")
    public List<Projects> FindAllProjects(@CookieValue(value = "UserID", defaultValue = "0") String UserID,
                                          @CookieValue(value = "UserPassword", defaultValue = "") String UserPassword) {
        operation.setOperationDescription("GET");
        objects.setObjectName("FindAllProjects");
        return projectService.FindAllProjects(Integer.parseInt(UserID), UserPassword, operation, objects);
    }

    @GetMapping(value = "/projectAssignment/", produces = "application/json;charset=UTF-8")
    public List<ProjectAssignmentResult> FindTeamByProject(@RequestParam(name = "ProjectID") Integer ProjectID,
                                                           @CookieValue(value = "UserID", defaultValue = "0") String UserID,
                                                           @CookieValue(value = "UserPassword", defaultValue = "") String UserPassword) {
        operation.setOperationDescription("GET");
        objects.setObjectName("FindTeamByProject");
        return projectService.FindTeamByProject(Integer.parseInt(UserID), UserPassword, operation, objects, ProjectID);
    }

    @GetMapping(value = "/project", produces = "application/json;charset=UTF-8")
    public Project FindProjectByUser(@RequestParam(name = "UserID") Integer UserID,
                                     @CookieValue(value = "UserPassword", defaultValue = "") String UserPassword) {
        operation.setOperationDescription("GET");
        objects.setObjectName("FindProjectByUser");
        return projectService.FindProjectByUser(UserID, UserPassword, operation, objects);
    }

    @PostMapping(value = "/project", produces = "application/json;charset=UTF-8")
    public ResultStatus BuildNewProject(@RequestParam(value = "UserID", defaultValue = "0") String UserID,
                                        @RequestParam(value = "UserPassword", defaultValue = "") String UserPassword,
                                        @RequestParam(name = "ProjectName") String ProjectName,
                                        @RequestParam(name = "Description") String Description) {
        operation.setOperationDescription("POST");
        objects.setObjectName("BuildNewProject");
        return projectService.BulidNewProject(Integer.parseInt(UserID), UserPassword, operation, objects, ProjectName, Description);
    }
}

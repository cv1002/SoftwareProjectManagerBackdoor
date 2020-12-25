package cn.edu.xjtu.stu.orangesoft.backdoor.controller;

import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Object;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Operation;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Projects;
import cn.edu.xjtu.stu.orangesoft.backdoor.service.FindAllProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController {
    @Autowired
    FindAllProjectsService findAllProjectsService;
    @Autowired
    Operation operation;
    @Autowired
    Object object;

    @GetMapping(value = "/projects", produces = "application/json;charset=UTF-8")
    public List<Projects> FindAllProjectsController(@CookieValue(value = "UserID", defaultValue = "0") String UserID,
                                                    @CookieValue(value = "UserPassword", defaultValue = "") String UserPassword) {
        operation.setOperationDescription("Get");
        object.setObjectName("FindAllProjects");
        return findAllProjectsService.FindAllProjects(Integer.parseInt(UserID),UserPassword,operation,object);
    }
}

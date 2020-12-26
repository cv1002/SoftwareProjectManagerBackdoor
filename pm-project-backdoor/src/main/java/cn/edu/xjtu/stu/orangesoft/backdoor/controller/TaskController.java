package cn.edu.xjtu.stu.orangesoft.backdoor.controller;

import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.FindTaskResult;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Task;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Tasks;
import cn.edu.xjtu.stu.orangesoft.backdoor.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    TaskService taskService;

    // TODO 半成品
    @PostMapping(value = "/task", produces = "application/json;charset=UTF-8")
    public String AddTask(@RequestParam(name = "UserID") Integer userID,
                          @RequestParam(name = "UserPassword") String userPassword,
                          @RequestParam(name = "Task") Task task) {
        return taskService.AddTask(userID,userPassword,task);
    }
    @GetMapping(value = "/task", produces = "application/json;charset=UTF-8")
    public FindTaskResult GetTaskByUserID(@RequestParam(name = "UserID") Integer UserID,
                                          @RequestParam(name = "UserPassword") String UserPassword) {
        return  taskService.FindTaskByUserID(UserID,UserPassword);
    }
}

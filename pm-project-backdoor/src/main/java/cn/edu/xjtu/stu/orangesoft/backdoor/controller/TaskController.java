package cn.edu.xjtu.stu.orangesoft.backdoor.controller;

import cn.edu.xjtu.stu.orangesoft.backdoor.service.TaskService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {
    @Autowired
    TaskService taskService;
    @Autowired
    Gson gson;

    // TODO 半成品
    @PostMapping(value = "/task", produces = "application/json;charset=UTF-8")
    public String AddTask(@RequestParam(name = "UserID") Integer userID,
                          @RequestParam(name = "UserPassword") String userPassword,
                          @RequestParam(name = "TaskID") int taskID,
                          @RequestParam(name = "TaskName") String taskName,
                          @RequestParam(name = "TaskFinishType") int taskFinishType,
                          @RequestParam(name = "TaskDeadline") String taskDeadline,
                          @RequestParam(name = "TaskStartTime") String taskStartTime,
                          @RequestParam(name = "TaskHandlerID") int taskHandlerID,
                          @RequestParam(name = "TaskPublisherID") int taskPublisherID,
                          @RequestParam(name = "TaskDescription") String taskDescription) {
        return taskService.AddTask(userID, userPassword, taskID, taskName, taskFinishType, taskDeadline, taskStartTime, taskHandlerID, taskPublisherID, taskDescription);
    }

    @GetMapping(value = "/task", produces = "application/json;charset=UTF-8")
    public String GetTaskByUserID(@RequestParam(name = "UserID") Integer UserID,
                                  @RequestParam(name = "UserPassword") String UserPassword) {
        return gson.toJson(taskService.FindTaskByUserID(UserID, UserPassword));
    }

    @DeleteMapping(value = "/task", produces = "application/json;charset=UTF-8")
    public String DeleteTask(@RequestParam(name = "UserID") int UserID,
                             @RequestParam(name = "UserPassword") String UserPassword,
                             @RequestParam("TaskID") int taskID) {
        return taskService.DeleteTask(UserID, UserPassword, taskID);
    }

    @PutMapping(value = "/task", produces = "application/json;charset=UTF-8")
    public String UpdateTask(@RequestParam(name = "UserID") Integer userID,
                             @RequestParam(name = "UserPassword") String userPassword,
                             @RequestParam(name = "TaskID") int taskID,
                             @RequestParam(name = "TaskName") String taskName,
                             @RequestParam(name = "TaskFinishType") int taskFinishType,
                             @RequestParam(name = "TaskDeadline") String taskDeadline,
                             @RequestParam(name = "TaskStartTime") String taskStartTime,
                             @RequestParam(name = "TaskHandlerID") int taskHandlerID,
                             @RequestParam(name = "TaskPublisherID") int taskPublisherID,
                             @RequestParam(name = "TaskDescription") String taskDescription,
                             @RequestParam(name = "TeamID") int teamID) {
        return taskService.TaskUpdate(userID, userPassword, taskID, taskName, taskFinishType, taskDeadline, taskStartTime, taskHandlerID, taskPublisherID, taskDescription);
    }
}

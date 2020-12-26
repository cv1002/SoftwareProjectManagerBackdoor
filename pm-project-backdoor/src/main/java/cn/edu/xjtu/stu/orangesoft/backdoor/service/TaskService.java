package cn.edu.xjtu.stu.orangesoft.backdoor.service;

import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.StudentMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.TaskMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.UserMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

// TODO 缺少RBAC
@Service
public class TaskService {
    @Autowired
    TaskMapper taskmapper;

    @Autowired
    UserMapper usermapper;

    @Autowired
    StudentMapper studentmapper;

    public FindTaskResult FindTaskByUserID(Integer userID, String userPassword) {
        Tasks tasks = new Tasks();
        FindTaskResult findTaskResult = new FindTaskResult();

        User user = usermapper.GetUserByIDAndPassword(userID, userPassword);
        if (user == null) {
            return null;
        } else {
            List<Task> taskResult = taskmapper.GetTaskByUserID(userID);
            List<Tasks> tasksResult = new ArrayList<>();

            // 遍历查出来的Task，加入TaskHandlerName以及TaskPublisherName，构造成Tasks，再返回
            for (Task tempTask : taskResult) {
                tasks.setTaskID(tempTask.getTaskID());
                tasks.setTaskName(tempTask.getTaskName());
                tasks.setTaskHandlerID(tempTask.getTaskHandlerID());
                tasks.setTaskFinishType(tempTask.getTaskFinishType());
                tasks.setTaskDescription(tempTask.getTaskDescription());
                tasks.setTaskPublisherID(tempTask.getTaskPublisherID());
                tasks.setTaskStartTime(tempTask.getTaskStartTime());
                tasks.setTaskDeadline(tempTask.getTaskDeadline());
                user = usermapper.GetUserByUserID(tempTask.getTaskHandlerID());
                if (user != null) {
                    tasks.setTaskHandlerName(user.getUserName());
                }
                tasks.setTaskHandlerName(usermapper.GetUserByUserID(tempTask.getTaskPublisherID()).getUserName());
                tasksResult.add(tasks);
            }
            findTaskResult.SetFinish("success");
            findTaskResult.SetTasks(tasksResult);
        }
        System.out.println(findTaskResult.GetFinish());
        return findTaskResult;
    }

    public String AddTask(int userID, String userPassword, int taskID, String taskName, int taskFinishType, String taskDeadline, String taskStartTime, int taskHandlerID, int taskPublisherID, String taskDescription) {
        Task newTask = new Task();
        newTask.setTaskName(taskName);
        newTask.setTaskID(taskID);
        newTask.setTaskHandlerID(taskHandlerID);
        newTask.setTaskFinishType(taskFinishType);
        newTask.setTaskDescription(taskDescription);
        newTask.setTaskDeadline(taskDeadline);
        newTask.setTaskPublisherID(taskPublisherID);
        newTask.setTaskStartTime(taskStartTime);
        User user = usermapper.GetUserByIDAndPassword(userID, userPassword);
        if (user == null) {
            return null;
        }
        if (taskmapper.AddTask(newTask.getTaskID(), newTask.getTaskName(), userID,
                newTask.getTaskFinishType(), newTask.getTaskDeadline(),
                newTask.getTaskStartTime(), newTask.getTaskHandlerID(),
                newTask.getTaskDescription()) == 1) {
            return "success";
        }
        return null;
    }

    public String TaskUpdate(int userID, String userPassword, int taskID, String taskName, int taskFinishType, String taskDeadline, String taskStartTime, int taskHandlerID, int taskPublisherID, String taskDescription) {
        Task newTask = new Task();
        newTask.setTaskName(taskName);
        newTask.setTaskID(taskID);
        newTask.setTaskHandlerID(taskHandlerID);
        newTask.setTaskFinishType(taskFinishType);
        newTask.setTaskDescription(taskDescription);
        newTask.setTaskDeadline(taskDeadline);
        newTask.setTaskPublisherID(taskPublisherID);
        newTask.setTaskStartTime(taskStartTime);
        User user = usermapper.GetUserByIDAndPassword(userID, userPassword);
        if (user == null) {
            return null;
        }
        if (taskmapper.UpdateTask(taskID, newTask.getTaskName(), newTask.getTaskPublisherID(), newTask.getTaskFinishType(),
                newTask.getTaskDeadline(), newTask.getTaskStartTime(),
                newTask.getTaskHandlerID(), newTask.getTaskDescription()) == 1) {
            return "success";
        } else {
            return null;
        }

    }

    public String DeleteTask(Integer userID, String userPassword, int taskID) {
        User user = usermapper.GetUserByIDAndPassword(userID, userPassword);
        if (user == null) {
            return null;
        }
        if (taskmapper.DeleteTask(taskID) == 1) {
            return "success";
        }
        return null;
    }
}

package cn.edu.xjtu.stu.orangesoft.backdoor.service;

import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.StudentMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.TaskMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.UserMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TaskService {
    @Autowired
    TaskMapper taskmapper;

    @Autowired
    UserMapper usermapper;

    @Autowired
    StudentMapper studentmapper;

    public FindTaskResult FindTaskByUserID(Integer userID, String userPassword) {

        FindTaskResult findTaskResult=new FindTaskResult();

        User user=usermapper.GetUserByIDAndPassword(userID, userPassword);
        if(user==null){
            return null;
        }
        else {
            findTaskResult.SetFinish("success");
            findTaskResult.SetTasks(taskmapper.GetTasksByUserID(userID));
        }
        return findTaskResult;
    }

    public String AddTask(int userID,String userPassword,Task newTask) {
        User user=usermapper.GetUserByIDAndPassword(userID, userPassword);
        if(user==null){
            return null;
        }
        if (taskmapper.AddTask(newTask.getTaskName(), userID,
                newTask.getTaskFinishType(), newTask.getTaskDeadline(),
                newTask.getTaskStartTime(), newTask.getTaskHandlerID(),
                newTask.getTaskDescription())==1)
        {
            return "success";
        }
        return null;
    }

    public String TaskUpdate(Integer taskID, Task newTask, Integer userID, String userPassword) {

        User user = usermapper.GetUserByIDAndPassword(userID, userPassword);
        if (user == null) {
            return null;
        }
        Task tarTask = taskmapper.GetTaskByTaskID(taskID);
        List<Task> task = taskmapper.GetTaskByUserID(userID);
        Student student = studentmapper.GetStudentByStudentID(newTask.getTaskHandlerID());
        if (student == null) {
            return null;
        }
        if (task.contains(tarTask)) {
//            tarTask.setTaskStartTime(newTask.getTaskStartTime());
//            tarTask.setTaskPublisherID(newTask.getTaskPublisherID());
//            tarTask.setTaskDeadline(newTask.getTaskDeadline());
//            tarTask.setTaskDescription(newTask.getTaskDescription());
//            tarTask.setTaskFinishType(newTask.getTaskFinishType());
//            tarTask.setTaskHandlerID(newTask.getTaskHandlerID());
//            tarTask.setTaskID(newTask.getTaskID());
//            tarTask.setTaskName(newTask.getTaskName());
            if (taskmapper.UpdateTask(taskID, newTask.getTaskName(), newTask.getTaskFinishType(),
                    newTask.getTaskDeadline(), newTask.getTaskStartTime(),
                    newTask.getTaskHandlerID(), newTask.getTaskDescription()) == 1) {
                return "success";
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}

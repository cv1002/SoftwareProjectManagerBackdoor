package cn.edu.xjtu.stu.orangesoft.backdoor.service;

import cn.edu.xjtu.stu.orangesoft.backdoor.core.DIUtil;
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

    public FindTaskResult GetTaskByPublisherID(Integer userID) {
        FindTaskResult findTaskResult = DIUtil.getBean(FindTaskResult.class);
        List<Task> taskResult = taskmapper.GetTaskByPublisherID(userID);
        List<Tasks> tasksResult = PackTasksResult(taskResult);
        findTaskResult.setFinish("成功！！");
        findTaskResult.setTasks(tasksResult);
        return findTaskResult;
    }

    public FindTaskResult GetTaskByHandlerID(Integer userID) {
        FindTaskResult findTaskResult = DIUtil.getBean(FindTaskResult.class);
        List<Task> taskResult = taskmapper.GetTaskByHandlerID(userID);
        List<Tasks> tasksResult = PackTasksResult(taskResult);
        findTaskResult.setFinish("成功！！");
        findTaskResult.setTasks(tasksResult);
        return findTaskResult;
    }

    private List<Tasks> PackTasksResult(List<Task> taskResult) {
        List<Tasks> tasksResult = new ArrayList<>();
        System.out.println(taskResult.size());
        // 遍历查出来的Task，加入TaskHandlerName以及TaskPublisherName，构造成Tasks，再返回
        for (Task tempTask : taskResult) {
            Tasks tasks = DIUtil.getBean(Tasks.class);
            tasks.setTaskID(tempTask.getTaskID());
            tasks.setTaskName(tempTask.getTaskName());
            tasks.setTaskHandlerID(tempTask.getTaskHandlerID());
            tasks.setTaskFinishType(tempTask.getTaskFinishType());
            tasks.setTaskDescription(tempTask.getTaskDescription());
            tasks.setTaskPublisherID(tempTask.getTaskPublisherID());
            tasks.setTaskStartTime(tempTask.getTaskStartTime());
            tasks.setTaskDeadline(tempTask.getTaskDeadline());
            User user = usermapper.GetUserByUserID(tempTask.getTaskHandlerID());
            if (user != null) {
                tasks.setTaskHandlerName(user.getUserName());
            }
            tasks.setTaskPublisherName(usermapper.GetUserByUserID(tempTask.getTaskPublisherID()).getUserName());
            tasksResult.add(tasks);
        }
        return tasksResult;
    }

    public ResultInfo AddTask(int userID, String taskName, int taskFinishType, String taskDeadline, String taskStartTime, int taskHandlerID, int taskPublisherID, String taskDescription) {
        Task newTask = DIUtil.getBean(Task.class);
        newTask.setTaskName(taskName);
        newTask.setTaskID(0);
        newTask.setTaskHandlerID(taskHandlerID);
        newTask.setTaskFinishType(taskFinishType);
        newTask.setTaskDescription(taskDescription);
        newTask.setTaskDeadline(taskDeadline);
        newTask.setTaskPublisherID(taskPublisherID);
        newTask.setTaskStartTime(taskStartTime);

        ResultInfo resultInfo = DIUtil.getBean(ResultInfo.class);
        if (taskmapper.AddTask(newTask.getTaskID(), newTask.getTaskName(), userID,
                newTask.getTaskFinishType(), newTask.getTaskDeadline(),
                newTask.getTaskStartTime(), newTask.getTaskHandlerID(),
                newTask.getTaskDescription()) == 1) {
            resultInfo.setResultInfo("成功！！");
        } else {
            resultInfo.setResultInfo("失败！！");
        }
        return resultInfo;
    }

    public ResultInfo TaskUpdate(int taskID, String taskName, int taskFinishType, String taskDeadline, String taskStartTime, int taskHandlerID, int taskPublisherID, String taskDescription) {
        Task newTask = DIUtil.getBean(Task.class);
        newTask.setTaskName(taskName);
        newTask.setTaskID(taskID);
        newTask.setTaskHandlerID(taskHandlerID);
        newTask.setTaskFinishType(taskFinishType);
        newTask.setTaskDescription(taskDescription);
        newTask.setTaskDeadline(taskDeadline);
        newTask.setTaskPublisherID(taskPublisherID);
        newTask.setTaskStartTime(taskStartTime);

        ResultInfo resultInfo = new ResultInfo();
        if (taskmapper.UpdateTask(taskID, newTask.getTaskName(), newTask.getTaskPublisherID(), newTask.getTaskFinishType(),
                newTask.getTaskDeadline(), newTask.getTaskStartTime(),
                newTask.getTaskHandlerID(), newTask.getTaskDescription()) == 1) {
            resultInfo.setResultInfo("成功！！");
        } else {
            resultInfo.setResultInfo("失败！！");
        }
        return resultInfo;

    }

    public ResultInfo DeleteTask(int taskID) {
        ResultInfo resultInfo = new ResultInfo();
        if (taskmapper.DeleteTask(taskID) == 1) {
            resultInfo.setResultInfo("成功！！");
        } else {
            resultInfo.setResultInfo("出错！！");
        }
        return resultInfo;
    }
}

package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import org.springframework.stereotype.Component;

@Component
public class Task {
    private int TaskID;
    private String TaskName;
    private String TaskDeadline;
    private int TaskHandlerID;
    private int TaskFinishType;
    private String TaskStartTime;
    private int TaskPublisherID;
    private String TaskDescription;

    public int getTaskID() {
        return TaskID;
    }

    public void setTaskID(int taskID) {
        TaskID = taskID;
    }

    public String getTaskName() {
        return TaskName;
    }

    public void setTaskName(String taskName) {
        TaskName = taskName;
    }

    public String getTaskDeadline() {
        return TaskDeadline;
    }

    public void setTaskDeadline(String taskDeadline) {
        TaskDeadline = taskDeadline;
    }

    public int getTaskHandlerID() {
        return TaskHandlerID;
    }

    public void setTaskHandlerID(int taskHandlerID) {
        TaskHandlerID = taskHandlerID;
    }

    public int getTaskFinishType() {
        return TaskFinishType;
    }

    public void setTaskFinishType(int taskFinishType) {
        TaskFinishType = taskFinishType;
    }

    public String getTaskStartTime() {
        return TaskStartTime;
    }

    public void setTaskStartTime(String taskStartTime) {
        TaskStartTime = taskStartTime;
    }

    public int getTaskPublisherID() {
        return TaskPublisherID;
    }

    public void setTaskPublisherID(int taskPublisherID) {
        TaskPublisherID = taskPublisherID;
    }

    public String getTaskDescription() {
        return TaskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        TaskDescription = taskDescription;
    }
}

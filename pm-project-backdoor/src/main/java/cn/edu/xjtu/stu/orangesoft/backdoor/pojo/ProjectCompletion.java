package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import org.springframework.stereotype.Component;

@Component
public class ProjectCompletion {
    private int FileID;
    private int CompletionID;
    private int TeamID;
    private int MilestoneID;

    public int getFileID() {
        return FileID;
    }

    public void setFileID(int fileID) {
        FileID = fileID;
    }

    public int getCompletionID() {
        return CompletionID;
    }

    public void setCompletionID(int completionID) {
        CompletionID = completionID;
    }

    public int getTeamID() {
        return TeamID;
    }

    public void setTeamID(int teamID) {
        TeamID = teamID;
    }

    public int getMilestoneID() {
        return MilestoneID;
    }

    public void setMilestoneID(int milestoneID) {
        MilestoneID = milestoneID;
    }
}

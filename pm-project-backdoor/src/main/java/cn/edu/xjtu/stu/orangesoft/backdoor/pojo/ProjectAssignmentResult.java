package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import org.springframework.stereotype.Component;

@Component
public class ProjectAssignmentResult {
    private int TeamID;
    private String ProjectStartTime;
    private String ProjectDeadline;

    public int getTeamID() {
        return TeamID;
    }

    public void setTeamID(int teamID) {
        TeamID = teamID;
    }

    public String getProjectStartTime() {
        return ProjectStartTime;
    }

    public void setProjectStartTime(String projectStartTime) {
        ProjectStartTime = projectStartTime;
    }

    public String getProjectDeadline() {
        return ProjectDeadline;
    }

    public void setProjectDeadline(String projectDeadline) {
        ProjectDeadline = projectDeadline;
    }
}

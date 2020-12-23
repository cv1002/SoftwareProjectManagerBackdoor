package cn.edu.xjtu.stu.orangesoft.backdoor.bean;

import org.springframework.stereotype.Component;

@Component
public class ProjectAssignment {
    private int ProjectID;
    private int TeamID;
    private String ProjectStartTime;
    private String ProjectDeadline;

    public int getProjectID() {
        return ProjectID;
    }

    public void setProjectID(int projectID) {
        ProjectID = projectID;
    }

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

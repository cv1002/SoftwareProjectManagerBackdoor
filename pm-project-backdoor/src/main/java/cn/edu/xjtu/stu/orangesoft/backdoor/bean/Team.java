package cn.edu.xjtu.stu.orangesoft.backdoor.bean;

import org.springframework.stereotype.Component;

@Component
public class Team {
    private int TeamID;
    private String TeamName;
    private String TeamDescription;

    public int getTeamID() {
        return TeamID;
    }

    public void setTeamID(int teamID) {
        TeamID = teamID;
    }

    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String teamName) {
        TeamName = teamName;
    }

    public String getTeamDescription() {
        return TeamDescription;
    }

    public void setTeamDescription(String teamDescription) {
        TeamDescription = teamDescription;
    }
}

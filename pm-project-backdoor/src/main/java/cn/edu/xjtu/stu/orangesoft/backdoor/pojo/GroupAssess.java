package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import org.springframework.stereotype.Component;

@Component
public class GroupAssess {
    private int TeamID;
    private int Score;
    private String TeamAssess;
    private int AssessorID;

    public int getTeamID() {
        return TeamID;
    }

    public void setTeamID(int teamID) {
        TeamID = teamID;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public String getTeamAssess() {
        return TeamAssess;
    }

    public void setTeamAssess(String teamAssess) {
        TeamAssess = teamAssess;
    }

    public int getAssessorID() {
        return AssessorID;
    }

    public void setAssessorID(int assessorID) {
        AssessorID = assessorID;
    }
}

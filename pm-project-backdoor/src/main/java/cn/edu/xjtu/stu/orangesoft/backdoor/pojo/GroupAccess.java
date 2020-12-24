package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import org.springframework.stereotype.Component;

@Component
public class GroupAccess {
    private int TeamID;
    private int Score;
    private String TeamAccess;
    private int AccessorID;

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

    public String getTeamAccess() {
        return TeamAccess;
    }

    public void setTeamAccess(String teamAccess) {
        TeamAccess = teamAccess;
    }

    public int getAccessorID() {
        return AccessorID;
    }

    public void setAccessorID(int accessorID) {
        AccessorID = accessorID;
    }
}

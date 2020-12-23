package cn.edu.xjtu.stu.orangesoft.backdoor.unusedbeans;

import org.springframework.stereotype.Component;

@Component
public class GroupAccess {
    private int TeamID;
    private int Score;
    private String TeamAccess;
    private int AccessorID;

    public void setTeamID(int teamID) {
        TeamID = teamID;
    }

    public void setScore(int score) {
        Score = score;
    }

    public void setTeamAccess(String teamAccess) {
        TeamAccess = teamAccess;
    }

    public void setAccessorID(int accessorID) {
        AccessorID = accessorID;
    }

    public int getTeamID() {
        return TeamID;
    }

    public int getScore() {
        return Score;
    }

    public String getTeamAccess() {
        return TeamAccess;
    }

    public int getAccessorID() {
        return AccessorID;
    }
}

package cn.edu.xjtu.stu.orangesoft.backdoor.unusedbeans;

import org.springframework.stereotype.Component;

@Component
public class Communication {
    private int CommunicationID;
    private String Context;
    private int UserID;
    private int FileID;
    private int TeamID;

    public int getCommunicationID() {
        return CommunicationID;
    }

    public void setCommunicationID(int communicationID) {
        CommunicationID = communicationID;
    }

    public String getContext() {
        return Context;
    }

    public void setContext(String context) {
        Context = context;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public int getFileID() {
        return FileID;
    }

    public void setFileID(int fileID) {
        FileID = fileID;
    }

    public int getTeamID() {
        return TeamID;
    }

    public void setTeamID(int teamID) {
        TeamID = teamID;
    }
}

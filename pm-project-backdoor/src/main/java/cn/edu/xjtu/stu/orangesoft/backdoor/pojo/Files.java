package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import org.springframework.stereotype.Component;

@Component
public class Files {
    private int FileID;
    private String FileRealName;
    private String FileType;
    private String FileLocation;
    private int TeamID;
    private int StudentUserID;
    private String UpLoadTime;

    public int getFileID() {
        return FileID;
    }

    public void setFileID(int fileID) {
        FileID = fileID;
    }

    public String getFileRealName() {
        return FileRealName;
    }

    public void setFileRealName(String fileRealName) {
        FileRealName = fileRealName;
    }

    public String getFileType() {
        return FileType;
    }

    public void setFileType(String fileType) {
        FileType = fileType;
    }

    public String getFileLocation() {
        return FileLocation;
    }

    public void setFileLocation(String fileLocation) {
        FileLocation = fileLocation;
    }

    public int getTeamID() {
        return TeamID;
    }

    public void setTeamID(int teamID) {
        TeamID = teamID;
    }

    public int getStudentUserID() {
        return StudentUserID;
    }

    public void setStudentUserID(int studentUserID) {
        StudentUserID = studentUserID;
    }

    public String getUpLoadTime() {
        return UpLoadTime;
    }

    public void setUpLoadTime(String upLoadTime) {
        UpLoadTime = upLoadTime;
    }
}

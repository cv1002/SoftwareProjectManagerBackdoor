package cn.edu.xjtu.stu.orangesoft.backdoor.unusedbeans;

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

    public void setFileID(int fileID) {
        FileID = fileID;
    }

    public void setFileRealName(String fileRealName) {
        FileRealName = fileRealName;
    }

    public void setFileType(String fileType) {
        FileType = fileType;
    }

    public void setFileLocation(String fileLocation) {
        FileLocation = fileLocation;
    }

    public void setTeamID(int teamID) {
        TeamID = teamID;
    }

    public void setStudentUserID(int studentUserID) {
        StudentUserID = studentUserID;
    }

    public void setUpLoadTime(String upLoadTime) {
        UpLoadTime = upLoadTime;
    }

    public int getFileID() {
        return FileID;
    }

    public String getFileRealName() {
        return FileRealName;
    }

    public String getFileType() {
        return FileType;
    }

    public String getFileLocation() {
        return FileLocation;
    }

    public int getTeamID() {
        return TeamID;
    }

    public int getStudentUserID() {
        return StudentUserID;
    }

    public String getUpLoadTime() {
        return UpLoadTime;
    }
}

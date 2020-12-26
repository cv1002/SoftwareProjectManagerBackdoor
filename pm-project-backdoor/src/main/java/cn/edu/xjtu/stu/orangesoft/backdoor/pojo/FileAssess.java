package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import org.springframework.stereotype.Component;

@Component
public class FileAssess {
    private int FileID;
    private String FileAssess;
    private int AssesserID;
    private String AccessTime;

    public int getFileID() {
        return FileID;
    }

    public void setFileID(int fileID) {
        FileID = fileID;
    }

    public String getFileAssess() {
        return FileAssess;
    }

    public void setFileAssess(String fileAssess) {
        FileAssess = fileAssess;
    }

    public int getAssesserID() {
        return AssesserID;
    }

    public void setAssesserID(int assesserID) {
        AssesserID = assesserID;
    }

    public String getAccessTime() {
        return AccessTime;
    }

    public void setAccessTime(String accessTime) {
        AccessTime = accessTime;
    }
}

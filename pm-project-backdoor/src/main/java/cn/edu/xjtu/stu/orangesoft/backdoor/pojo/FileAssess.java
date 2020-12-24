package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import org.springframework.stereotype.Component;

@Component
public class FileAssess {
    private int FileID;
    private String FileAssess;
    private int AssesserID;
    private String AssessTime;

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

    public String getAssessTime() {
        return AssessTime;
    }

    public void setAssessTime(String assessTime) {
        AssessTime = assessTime;
    }
}

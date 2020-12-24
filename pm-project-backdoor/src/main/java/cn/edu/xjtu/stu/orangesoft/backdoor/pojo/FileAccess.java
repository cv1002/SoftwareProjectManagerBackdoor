package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import org.springframework.stereotype.Component;

@Component
public class FileAccess {
    private int FileID;
    private String FileAccess;
    private int AccesserID;
    private String AccessTime;

    public int getFileID() {
        return FileID;
    }

    public void setFileID(int fileID) {
        FileID = fileID;
    }

    public String getFileAccess() {
        return FileAccess;
    }

    public void setFileAccess(String fileAccess) {
        FileAccess = fileAccess;
    }

    public int getAccesserID() {
        return AccesserID;
    }

    public void setAccesserID(int accesserID) {
        AccesserID = accesserID;
    }

    public String getAccessTime() {
        return AccessTime;
    }

    public void setAccessTime(String accessTime) {
        AccessTime = accessTime;
    }
}

package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import org.springframework.stereotype.Component;

@Component
public class FileContent {
    private Integer FileID;
    private byte[] FileContent;
    public byte[] getFileContent() { return FileContent; }
    public Integer getFileID() { return FileID; }
    public void setFileContent(byte[] fileContent) { FileContent = fileContent; }
    public void setFileID(Integer fileID) { FileID = fileID; }
}

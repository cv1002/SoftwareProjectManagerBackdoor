package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import java.util.List;

public class FilesResult {
    private String finish;
    private List<Files> files;

    public List<Files> getFiles() {
        return files;
    }

    public void setFiles(List<Files> files) {
        this.files = files;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }
}

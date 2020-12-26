package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FileResult {
    private List<Files> files;
    private String Finish;


    public List<Files> getFile() {
        return files;
    }

    public void setFile(List<Files> file) {
        files = file;
    }

    public String getFinish() {
        return Finish;
    }

    public void setFinish(String finish) {
        Finish = finish;
    }
}

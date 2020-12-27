package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class FileAssess {
    private int FileID;
    private String FileAssess;
    private int AssesserID;
    private String AssessTime;
}

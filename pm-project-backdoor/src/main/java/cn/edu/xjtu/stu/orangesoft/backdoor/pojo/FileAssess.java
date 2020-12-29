package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Data
public class FileAssess {
    private int FileID;
    private String FileAssess;
    private int AssessorID;
    private String AssessTime;
}

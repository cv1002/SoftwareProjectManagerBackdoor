package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Data
public class StudentAssess {
    private int Score;
    private String Assess;
    private int StudentUserID;
    private int AssessorID;
}

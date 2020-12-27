package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class StudentAssess {
    private int Score;
    private String Assess;
    private int StudentUserID;
    private int AssessorID;
}

package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class GroupAssess {
    private int TeamID;
    private int Score;
    private String TeamAssess;
    private int AssessorID;
}

package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProjectAssignment {
    private int ProjectID;
    private int TeamID;
    private String ProjectStartTime;
    private String ProjectDeadline;
}

package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class RolePowerAssignment {
    private int AssignmentID;
    private int RoleID;
    private String ConfigID;
}

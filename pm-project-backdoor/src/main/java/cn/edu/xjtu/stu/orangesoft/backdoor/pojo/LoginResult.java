package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class LoginResult {
    private String Finish;
    private String LoginType;
    private int TeamID;
    private String TeamName;
    private String RoleName;
}

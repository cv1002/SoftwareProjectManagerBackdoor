package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Data
public class LoginResult {
    private String Finish;
    private String LoginType;
    private int TeamID;
    private String TeamName;
    private String RoleName;
}

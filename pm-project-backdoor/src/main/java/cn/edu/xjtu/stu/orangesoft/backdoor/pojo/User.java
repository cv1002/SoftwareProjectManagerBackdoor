package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class User {
    private int UserID;
    private String UserName;
    private String UserPassword;
    private int RoleID;
    private int Tel;
    private String EMail;
    private String UserIconLocation;
    private String Sex;
}

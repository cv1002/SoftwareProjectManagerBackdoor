package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Data
public class User {
    private int UserID;
    private String UserName;
    private String UserPassword;
    private int RoleID;
    private long Tel;
    private String EMail;
    private String UserIconLocation;
    private String Sex;
}

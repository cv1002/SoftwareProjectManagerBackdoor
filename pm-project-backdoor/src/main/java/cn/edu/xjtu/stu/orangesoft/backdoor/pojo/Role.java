package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Data
public class Role {
    private Integer RoleID;
    private String RoleName;
}

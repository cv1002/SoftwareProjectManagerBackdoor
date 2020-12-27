package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Data
public class PermissionConfig {
    private String ConfigID;
    private String ObjectName;
    private String OperationDescription;
    private int Permission;
}

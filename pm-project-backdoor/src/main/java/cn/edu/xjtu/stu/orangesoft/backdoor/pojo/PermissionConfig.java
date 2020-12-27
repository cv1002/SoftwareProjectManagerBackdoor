package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PermissionConfig {
    private String ConfigID;
    private String ObjectName;
    private String OperationDescription;
    private int Permission;
}

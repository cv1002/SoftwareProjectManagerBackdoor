package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Data
public class RBACQueryResult {
    int AssignmentID;
    int ConfigID;
    int Permission;
    String ObjectName;
    String OperationDescription;
}

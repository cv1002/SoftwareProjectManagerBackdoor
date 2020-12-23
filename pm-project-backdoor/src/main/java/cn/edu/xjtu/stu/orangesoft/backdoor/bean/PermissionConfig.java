package cn.edu.xjtu.stu.orangesoft.backdoor.bean;

import org.springframework.stereotype.Component;

@Component
public class PermissionConfig {
    private String ConfigID;
    private String ObjectName;
    private String OperationDescription;
    private int Permission;

    public String getConfigID() {
        return ConfigID;
    }

    public void setConfigID(String configID) {
        ConfigID = configID;
    }

    public String getObjectName() {
        return ObjectName;
    }

    public void setObjectName(String objectName) {
        ObjectName = objectName;
    }

    public String getOperationDescription() {
        return OperationDescription;
    }

    public void setOperationDescription(String operationDescription) {
        OperationDescription = operationDescription;
    }

    public int getPermission() {
        return Permission;
    }

    public void setPermission(int permission) {
        Permission = permission;
    }
}

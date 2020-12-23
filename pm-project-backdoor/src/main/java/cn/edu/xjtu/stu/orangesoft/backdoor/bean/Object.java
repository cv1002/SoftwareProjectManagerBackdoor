package cn.edu.xjtu.stu.orangesoft.backdoor.bean;

import org.springframework.stereotype.Component;

@Component
public class Object {
    private String ObjectName;

    public String getObjectName() {
        return ObjectName;
    }

    public void setObjectName(String objectName) {
        ObjectName = objectName;
    }
}

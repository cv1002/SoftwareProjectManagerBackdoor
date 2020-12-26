package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import org.springframework.stereotype.Component;

@Component
public class Objects {
    private String ObjectName;

    public String getObjectName() {
        return ObjectName;
    }

    public void setObjectName(String objectName) {
        ObjectName = objectName;
    }
}

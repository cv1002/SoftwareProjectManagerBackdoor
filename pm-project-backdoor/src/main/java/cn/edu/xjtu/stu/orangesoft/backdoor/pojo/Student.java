package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Data
public class Student {
    private int StudentUserID;
    private String StudentClass;
    private long StudentID;
    private int TeamID;
    private String Job;
}

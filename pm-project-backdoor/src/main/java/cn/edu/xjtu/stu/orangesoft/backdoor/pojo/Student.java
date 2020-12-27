package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Student {
    private int StudentUserID;
    private String StudentClass;
    private int StudentID;
    private int TeamID;
}

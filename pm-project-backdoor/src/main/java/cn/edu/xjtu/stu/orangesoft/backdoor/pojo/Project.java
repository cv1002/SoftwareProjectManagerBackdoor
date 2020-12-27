package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Project {
    private int ProjectID;
    private String ProjectName;
    private String ProjectDescription;
}

package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Data
public class Files {
    private int FileID;
    private String FileRealName;
    private String FileType;
    private String FileLocation;
    private int TeamID;
    private int StudentUserID;
    private String UpLoadTime;
}

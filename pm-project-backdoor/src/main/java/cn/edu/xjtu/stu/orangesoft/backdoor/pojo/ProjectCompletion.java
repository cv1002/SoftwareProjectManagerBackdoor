package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Data
public class ProjectCompletion {
    private int FileID;
    private int CompletionID;
    private int TeamID;
    private int MilestoneID;
}

package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;


import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
@Data
public class FindTaskResult {
    private String Finish;
    private List<Tasks> Tasks;
}

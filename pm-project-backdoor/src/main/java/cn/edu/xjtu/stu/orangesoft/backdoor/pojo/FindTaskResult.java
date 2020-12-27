package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class FindTaskResult {
    private String Finish;
    private List<Tasks> Tasks;
}

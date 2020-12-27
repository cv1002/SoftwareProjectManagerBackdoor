package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Team {
    private int TeamID;
    private String TeamName;
    private String TeamDescription;
}

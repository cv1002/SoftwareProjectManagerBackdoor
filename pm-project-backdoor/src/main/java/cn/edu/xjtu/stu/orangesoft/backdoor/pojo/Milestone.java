package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Milestone {
    private int MilestoneID;
    private String MilestoneName;
    private String MilestoneDescription;
}

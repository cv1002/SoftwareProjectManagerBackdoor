package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Communication {
    private int CommunicationID;
    private String Context;
    private int UserID;
    private int FileID;
    private int TeamID;
}

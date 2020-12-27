package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Data
public class Communication {
    private int CommunicationID;
    private String Context;
    private int UserID;
    private int FileID;
    private int TeamID;
}

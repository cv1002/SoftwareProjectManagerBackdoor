package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Data
public class TodoList {
    private int TodoListID;
    private int UserID;
    private String TodoThings;
    private int FinishState;
}

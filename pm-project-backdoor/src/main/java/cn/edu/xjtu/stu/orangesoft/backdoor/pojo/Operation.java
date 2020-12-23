package cn.edu.xjtu.stu.orangesoft.backdoor.unusedbeans;

import org.springframework.stereotype.Component;

@Component
public class Operation {
    private String OperationDescription;

    public String getOperationDescription() {
        return OperationDescription;
    }

    public void setOperationDescription(String operationDescription) {
        OperationDescription = operationDescription;
    }
}

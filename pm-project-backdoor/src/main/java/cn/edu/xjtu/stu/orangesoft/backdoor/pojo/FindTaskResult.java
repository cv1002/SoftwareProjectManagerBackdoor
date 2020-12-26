package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;


import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindTaskResult {
    private String Finish;
    private List<Tasks> Tasks;

    public String GetFinish() {
        return Finish;
    }

    public void SetFinish(String finish) {
        Finish = finish;
    }

    public List<Tasks> GetTasks() {
        return Tasks;
    }

    public void SetTasks(List<Tasks> tasks) {
        Tasks = tasks;
    }
}

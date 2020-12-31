package cn.edu.xjtu.stu.orangesoft.backdoor.service;

import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.TodoListMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.TodoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    TodoListMapper todoListMapper;

    /**
     * 查询用户的待办事项，包括已完成的
     *
     * @param UserID 用户ID
     * @return 用户待办事项列表
     */
    public List<TodoList> GetTodoListByUserID(int UserID) {
        return todoListMapper.GetTodoListByUserID(UserID);
    }
}

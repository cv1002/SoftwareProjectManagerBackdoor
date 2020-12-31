package cn.edu.xjtu.stu.orangesoft.backdoor.mapper;

import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.TodoList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TodoListMapper {
    List<TodoList> GetTodoListByUserID(int UserID);
}

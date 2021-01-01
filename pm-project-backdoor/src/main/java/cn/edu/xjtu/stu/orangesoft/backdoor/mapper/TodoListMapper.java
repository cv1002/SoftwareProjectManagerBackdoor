package cn.edu.xjtu.stu.orangesoft.backdoor.mapper;

import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.TodoList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TodoListMapper {
    List<TodoList> GetTodoListByUserID(@Param("UserID") int UserID);

    int AddTodoListItem(@Param("id") Integer UserID,
                        @Param("todoThings") String TodoThings);

    int UpdateTodoListItem(@Param("todoListID") Integer TodoListID,
                           @Param("todoThings") String TodoThings,
                           @Param("finishState") Integer FinishState);

    int DeleteTodoListItem(@Param("todoListID") Integer todoListID);
}

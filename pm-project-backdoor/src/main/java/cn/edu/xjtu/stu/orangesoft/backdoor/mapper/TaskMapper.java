package cn.edu.xjtu.stu.orangesoft.backdoor.mapper;

import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Task;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Tasks;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TaskMapper {
    List<Tasks> GetTasksByUserID(@Param("id") Integer UserID);

    List<Task> GetTaskByUserID(@Param("id") Integer UserID);

    Task GetTaskByTaskID(@Param("id") Integer TaskID);

    int AddTask(@Param("taskName") String TaskName,@Param("taskPublisherID") int TaskPublisherID,
                @Param("taskFinishType") int TaskFinishType, @Param("taskDeadline") String TaskDeadline,
                @Param("taskStartTime") String TaskStartTime, @Param("taskHandlerID") int TaskHandlerID,
                @Param("taskDescription") String TaskDescription);

    int UpdateTask(@Param("id") int TaskID, @Param("taskName") String TaskName,
                   @Param("taskFinishType") int TaskFinishType, @Param("taskDeadline") String TaskDeadline,
                   @Param("taskStartTime") String TaskStartTime, @Param("taskHandlerID") int TaskHandlerID,
                   @Param("taskDescription") String TaskDescription);
}

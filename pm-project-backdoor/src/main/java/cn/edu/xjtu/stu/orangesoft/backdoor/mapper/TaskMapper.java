package cn.edu.xjtu.stu.orangesoft.backdoor.mapper;

import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TaskMapper {
    List<Task> GetTaskByPublisherID(@Param("id") Integer UserID);

    List<Task> GetTaskByHandlerID(@Param("id") Integer UserID);

    Task GetTaskByTaskID(@Param("id") Integer TaskID);

    int AddTask(@Param("id") int TaskID, @Param("taskName") String TaskName, @Param("taskPublisherID") int TaskPublisherID,
                @Param("taskFinishType") int TaskFinishType, @Param("taskDeadline") String TaskDeadline,
                @Param("taskStartTime") String TaskStartTime, @Param("taskHandlerID") int TaskHandlerID,
                @Param("taskDescription") String TaskDescription);

    int UpdateTask(@Param("id") int TaskID, @Param("taskName") String TaskName, @Param("taskPublisherID") int TaskPublisherID,
                   @Param("taskFinishType") int TaskFinishType, @Param("taskDeadline") String TaskDeadline,
                   @Param("taskStartTime") String TaskStartTime, @Param("taskHandlerID") int TaskHandlerID,
                   @Param("taskDescription") String TaskDescription);

    int DeleteTask(@Param("id") int TaskID);
}

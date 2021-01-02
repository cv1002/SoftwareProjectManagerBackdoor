package cn.edu.xjtu.stu.orangesoft.backdoor.mapper;

import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.ProjectCompletion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MilestoneMapper {
    List<ProjectCompletion> GetCompletionByTeamID(@Param("id") Integer TeamID);

    ProjectCompletion GetCompletionByID(@Param("id") Integer CompletionID);

    int InsertCompletion(@Param("Completion") ProjectCompletion completion);

    int DeleteCompletion(@Param("id") Integer CompletionID);

    int UpdateCompletion(@Param("CompletionID") Integer CompletionID,
                         @Param("Completion") ProjectCompletion Completion);
}

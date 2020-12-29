package cn.edu.xjtu.stu.orangesoft.backdoor.mapper;

import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.ProjectAssignment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProjectAssignmentMapper {
    List<ProjectAssignment> getProjectAssignmentByProjectID(@Param("ProjectID") Integer ProjectID);

    Integer addProjectAssignment(@Param("ProjectAssignment") ProjectAssignment Assignment);
}

package cn.edu.xjtu.stu.orangesoft.backdoor.mapper;

import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Student;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Team;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeamMapper {
    Team GetTeamByTeamID(@Param("id") Integer TeamID);

    List<Student> GetTeamMembers(@Param("UserID") Integer UserID);

    List<Student> GetTeamMembersByTeamID(@Param("TeamID") Integer TeamID);

    List<Team> GetAllTeams();
}

package cn.edu.xjtu.stu.orangesoft.backdoor.mapper;

import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Team;
import org.apache.ibatis.annotations.Param;

public interface TeamMapper {
    Team GetTeamByTeamID(@Param("id") Integer TeamID);
}

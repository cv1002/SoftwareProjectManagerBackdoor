package cn.edu.xjtu.stu.orangesoft.backdoor.mapper;

import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Files;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
// todo
public interface FileMapper {
    Files GetFileByID(Integer FileID);
    Files GetFileByTeamID(@Param("TeamID") Integer TeamID);
}

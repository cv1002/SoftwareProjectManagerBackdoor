package cn.edu.xjtu.stu.orangesoft.backdoor.mapper;

import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Files;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.FilesResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
// todo
public interface FileMapper {
    Files GetFileByID(Integer FileID);
    List<Files> GetFileByTeamID(@Param("TeamID") Integer TeamID);
    Integer PostFiles(Files file);
    Integer PutFiles(Files file);
}

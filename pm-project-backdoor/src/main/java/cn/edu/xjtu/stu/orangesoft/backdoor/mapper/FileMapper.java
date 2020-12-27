package cn.edu.xjtu.stu.orangesoft.backdoor.mapper;

import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.FileContent;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Files;
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
    Integer PostFilesContent(FileContent fileContent);
    Integer PutFiles(Files file);
    Integer DeleteFiles(@Param("FIleID") Integer FileID);
}

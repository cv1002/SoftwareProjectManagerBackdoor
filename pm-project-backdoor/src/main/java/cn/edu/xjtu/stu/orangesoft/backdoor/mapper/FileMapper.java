package cn.edu.xjtu.stu.orangesoft.backdoor.mapper;

import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.FileContent;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.FileInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FileMapper {
    List<FileInfo> GetFileByID(@Param("FileID") Integer FileID);

    List<FileContent> GetFileContentByID(@Param("FileID") Integer FileID);

    List<FileInfo> GetFileByTeamID(@Param("TeamID") Integer TeamID);

    Integer PostFiles(@Param("file") FileInfo file);

    Integer PostFilesContent(@Param("fileContent") FileContent fileContent);

    Integer PutFiles(@Param("file") FileInfo file);

    Integer PutFilesContent(@Param("FileContent") FileContent fileContent);

    Integer DeleteFiles(@Param("FileID") Integer FileID);

    Integer DeleteFileContent(@Param("FileID") Integer FileID);
}

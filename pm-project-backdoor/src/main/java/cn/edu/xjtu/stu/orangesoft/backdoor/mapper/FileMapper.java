package cn.edu.xjtu.stu.orangesoft.backdoor.mapper;

import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.FileContent;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.FileInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
// todo
public interface FileMapper {
    List<FileInfo> GetFileByID(@Param("fileid") Integer FileID);

    List<FileContent> GetFileContentByID(@Param("fileid") Integer FileID);

    List<FileInfo> GetFileByTeamID(@Param("TeamID") Integer TeamID);

    Integer PostFiles(FileInfo file);

    Integer PostFilesContent(FileContent fileContent);

    Integer PutFiles(FileInfo file);

    Integer PutFilesContent(FileContent fileContent);

    Integer DeleteFiles(@Param("FileID") Integer FileID);

    Integer DeleteFileContent(@Param("FileID") Integer FileID);
}

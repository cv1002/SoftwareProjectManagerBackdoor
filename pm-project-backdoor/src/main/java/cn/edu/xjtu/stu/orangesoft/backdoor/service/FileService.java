package cn.edu.xjtu.stu.orangesoft.backdoor.service;

import cn.edu.xjtu.stu.orangesoft.backdoor.core.DIUtil;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.FileMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.StudentMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.UserMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class FileService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    FileMapper fileMapper;

    public ResultInfo deleteFile(Integer FileID) {
        ResultInfo resultInfo = DIUtil.getBean(ResultInfo.class);
        int affectedRows = fileMapper.DeleteFileContent(FileID);

        if (affectedRows == 0) {
            resultInfo.setResultInfo("不存在该文件！！");
        } else if (fileMapper.DeleteFiles(FileID) != 0) {
            resultInfo.setResultInfo("成功！！");
        } else {
            resultInfo.setResultInfo("未知错误！！");
        }
        return resultInfo;
    }

    public ResultInfo postFile(Integer userID, MultipartFile file) {
        return putFile(userID, 0, file);
    }

    public ResultInfo putFile(Integer userID, Integer fileID, MultipartFile file) {
        FileInfo fileInfo = new FileInfo();
        fileInfo.setFileRealName(file.getOriginalFilename());
        fileInfo.setFileLocation("database/");
        fileInfo.setFileType(file.getContentType());
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        fileInfo.setUpLoadTime(dateFormat.format(date));
        fileInfo.setStudentUserID(userID);
        Student student = studentMapper.GetStudentDataByUserID(userID);
        fileInfo.setTeamID(student.getTeamID());
        fileInfo.setFileID(fileID);


        ResultInfo resultInfo = DIUtil.getBean(ResultInfo.class);
        try {
            byte[] bytes = file.getBytes();
            int affectedRows = fileMapper.PutFiles(fileInfo);
            if (affectedRows == 0) {
                resultInfo.setResultInfo("无此ID的文件");
            } else {
                FileContent fileContent = new FileContent();
                fileContent.setFileContent(bytes);
                fileContent.setFileID(fileInfo.getFileID());
                affectedRows = fileMapper.PutFilesContent(fileContent);
                if (affectedRows == 0) {
                    resultInfo.setResultInfo("fail when trying to put file content");
                } else {
                    resultInfo.setResultInfo("update file success");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            resultInfo.setResultInfo("IO Exception..");
        }
        return resultInfo;
    }

    public FileResult getFileByFileID(Integer FileID) {
        if (FileID == null) {
            return null;
        } else {
            FileResult fileResult = DIUtil.getBean(FileResult.class);
            List<FileInfo> files = fileMapper.GetFileByID(FileID);
            List<FileContent> fileContents = fileMapper.GetFileContentByID(FileID);
            fileResult.setFiles(files);
            fileResult.setFileContents(fileContents);
            fileResult.setFinish("get file success");
            return fileResult;
        }
    }

    public FileResult getFileByTeamID(Integer TeamID) {
        FileResult filesResult = DIUtil.getBean(FileResult.class);
        if (TeamID == null) {
            filesResult.setFinish("不存在该TeamID的Team");
        } else {
            List<FileInfo> files = fileMapper.GetFileByTeamID(TeamID);
            filesResult.setFiles(files);
            filesResult.setFileContents(null);
            filesResult.setFinish("获取文件成功！！");
        }
        return filesResult;
    }
}

package cn.edu.xjtu.stu.orangesoft.backdoor.service;

import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.FileMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.UserMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Files;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//todo
@Service
public class FileService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    FileMapper fileMapper;

    public  Files getFilesByID(Integer FileID) {
        if(FileID == null) {
            return null;
        }
        else{
            Files file= fileMapper.GetFileByID(FileID);
            return file;
        }

    }
    public List<Files> getFileByTeamID(Integer TeamID){
        if(TeamID==null){
            return null;
        }
        else{
            List<Files> files= (List<Files>) fileMapper.GetFileByTeamID(TeamID);
            return files;
        }
    }

}

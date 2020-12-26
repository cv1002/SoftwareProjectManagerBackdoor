package cn.edu.xjtu.stu.orangesoft.backdoor.controller;

import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.*;
import cn.edu.xjtu.stu.orangesoft.backdoor.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class FileController {
    @Autowired
    FileService fileService;
    //TODO
    @GetMapping(value = "/file/{fileID}", produces = "application/json;charset=UTF-8")//等RBAC验证功能
    public Files getFile(@PathVariable("fileID") Integer FileID,
                          @CookieValue("userID") String UserID,
                          @CookieValue("userPassword") String UserPassword) {

        return fileService.getFilesByID(FileID);
    }
    @GetMapping(value = "/file", produces = "application/json;charset=UTF-8")
    public FilesResult getFiles(HttpServletRequest request) {
        Integer TeamID = Integer.parseInt(request.getParameter("TeamID"));
        return fileService.getFileByTeamID(TeamID);
    }
    @PostMapping(value = "/file" , produces = "application/json;charset=UTF-8")
    public String postFiles(/*@RequestParam(name = "file") Files file*/) {//具体怎么获取文件信息尚不清楚,fileassess？
        Files file = fileService.buildFile();
        return fileService.postFile(file);
    }
    @PutMapping(value = "/file" , produces = "application/json;charset=UTF-8")
    public String putFiles(HttpServletRequest request){
        Files file = fileService.buildFile();
        Integer FileID = Integer.parseInt(request.getParameter("FileID"));
        file.setFileID(FileID);
        return fileService.putFile(file);
    }
    @DeleteMapping(value = "/file" , produces = "application/json;charset=UTF-8")
    public String deleteFiles(HttpServletRequest request){
        Integer FileID = Integer.parseInt(request.getParameter("FileID"));
        return fileService.deleteFile(FileID);
    }








}

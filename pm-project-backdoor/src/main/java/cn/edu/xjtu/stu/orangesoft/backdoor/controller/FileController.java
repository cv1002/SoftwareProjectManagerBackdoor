package cn.edu.xjtu.stu.orangesoft.backdoor.controller;

import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.*;
import cn.edu.xjtu.stu.orangesoft.backdoor.service.FileService;
import cn.edu.xjtu.stu.orangesoft.backdoor.service.RBACService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class FileController {
    @Autowired
    FileService fileService;
    @Autowired
    Gson gson;
    //TODO
    Objects object = new Objects();
    Operation operation = new Operation();
    RBACService rbacService = new RBACService();
    @GetMapping(value = "/file/{fileID}", produces = "application/json;charset=UTF-8")//等RBAC验证功能
    public String getFile(@PathVariable("fileID") Integer FileID,
                          @CookieValue("userID") Integer UserID,
                          @CookieValue("userPassword") String UserPassword) {
        object.setObjectName("getFileByID");
        operation.setOperationDescription("GET");
        if(rbacService.CheckPermission(UserID, UserPassword, object, operation)){
            return gson.toJson(fileService.getFilesByID(FileID));
        }
        else{
            return gson.toJson("no permission");
        }
    }
    @GetMapping(value = "/file", produces = "application/json;charset=UTF-8")
    public String getFiles(HttpServletRequest request,
                               @CookieValue("userID") Integer UserID,
                               @CookieValue("userPassword") String UserPassword) {
        Integer TeamID = Integer.parseInt(request.getParameter("TeamID"));
        object.setObjectName("getFileByTeamID");
        FileResult fileResult = new FileResult();
        if(rbacService.CheckPermission(UserID, UserPassword, object, operation)){
            return gson.toJson(fileService.getFileByTeamID(TeamID));
        }
        else{
            return gson.toJson("no permission");
        }
    }
    @PostMapping(value = "/file" , produces = "application/json;charset=UTF-8")
    public String postFiles(/*@RequestParam(name = "file") Files file,*/
                            @CookieValue("userID") Integer UserID,
                            @CookieValue("userPassword") String UserPassword) {//具体怎么获取文件信息尚不清楚,fileassess？
        Files file = fileService.buildFile();
        object.setObjectName("postFile");
        operation.setOperationDescription("POST");
        if(rbacService.CheckPermission(UserID, UserPassword, object, operation)){
            return gson.toJson(fileService.postFile(file));
        }
        else{
         return gson.toJson("no permission");
        }
    }
    @PutMapping(value = "/file" , produces = "application/json;charset=UTF-8")
    public String putFiles(HttpServletRequest request,
                           @CookieValue("userID") Integer UserID,
                           @CookieValue("userPassword") String UserPassword){
        Files file = fileService.buildFile();
        Integer FileID = Integer.parseInt(request.getParameter("FileID"));
        file.setFileID(FileID);
        object.setObjectName("putFiles");
        operation.setOperationDescription("UPDATE");
        if(rbacService.CheckPermission(UserID, UserPassword, object, operation)) {
            return gson.toJson(fileService.postFile(file));
        }
        else{
            return gson.toJson("no permission");
        }

    }
    @DeleteMapping(value = "/file" , produces = "application/json;charset=UTF-8")
    public String deleteFiles(HttpServletRequest request,
                              @CookieValue("userID") Integer UserID,
                              @CookieValue("userPassword") String UserPassword){
        Integer FileID = Integer.parseInt(request.getParameter("FileID"));
        object.setObjectName("deleteFile");
        operation.setOperationDescription("DELETE");
        if(rbacService.CheckPermission(UserID, UserPassword, object, operation)) {
            return gson.toJson(fileService.deleteFile(FileID));
        }
        else{
            return gson.toJson("no permission");
        }
    }
}

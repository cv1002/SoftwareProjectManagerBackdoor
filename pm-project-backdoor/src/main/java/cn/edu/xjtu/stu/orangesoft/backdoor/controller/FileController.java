package cn.edu.xjtu.stu.orangesoft.backdoor.controller;

import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.StudentMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.UserMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.*;
import cn.edu.xjtu.stu.orangesoft.backdoor.service.FileService;
import cn.edu.xjtu.stu.orangesoft.backdoor.service.LoginService;
import cn.edu.xjtu.stu.orangesoft.backdoor.service.RBACService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class FileController {
    @Autowired
    FileService fileService;
    @Autowired
    Gson gson;
    @Autowired
    StudentMapper studentMapper;
    //TODO
    @GetMapping(value = "/file/{fileID}", produces = "application/json;charset=UTF-8")//等RBAC验证功能
    public String getFile(@PathVariable("fileID") Integer FileID,
                          @CookieValue("userID") Integer UserID,
                          @CookieValue("userPassword") String UserPassword) {
        Objects object = new Objects();
        Operation operation = new Operation();
        RBACService rbacService = new RBACService();
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
        Objects object = new Objects();
        Operation operation = new Operation();
        RBACService rbacService = new RBACService();
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
    public String postFiles(HttpServletRequest request,
                            @RequestParam(name = "file") MultipartFile file,
                            @CookieValue("userID") Integer UserID,
                            @CookieValue("userPassword") String UserPassword) throws IOException {//具体怎么获取文件信息尚不清楚,fileassess？
        Objects object = new Objects();
        Operation operation = new Operation();
        RBACService rbacService = new RBACService();
        object.setObjectName("postFile");
        operation.setOperationDescription("POST");

        Files saveFile = new Files();
        saveFile.setFileRealName(file.getOriginalFilename());
        saveFile.setFileLocation(request.getSession().getServletContext().getRealPath("/"));
        saveFile.setFileType(file.getContentType());
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        saveFile.setUpLoadTime(df.format(date));
        saveFile.setStudentUserID(UserID);
        Student student = studentMapper.GetStudentDataByUserID(UserID);
        saveFile.setTeamID(student.getTeamID());
        byte [] bytes = file.getBytes();
        if(rbacService.CheckPermission(UserID, UserPassword, object, operation)){
            String result = fileService.postFile(saveFile, bytes);
            return gson.toJson(result);
        }
        else{
         return gson.toJson("no permission");
        }
    }
    /*@PutMapping(value = "/file" , produces = "application/json;charset=UTF-8")
    public String putFiles(HttpServletRequest request,
                           @CookieValue("userID") Integer UserID,
                           @CookieValue("userPassword") String UserPassword){
        Integer FileID = Integer.parseInt(request.getParameter("FileID"));
        file.setFileID(FileID);
        Objects object = new Objects();
        Operation operation = new Operation();
        RBACService rbacService = new RBACService();
        object.setObjectName("putFiles");
        operation.setOperationDescription("UPDATE");
        if(rbacService.CheckPermission(UserID, UserPassword, object, operation)) {
            return gson.toJson(fileService.putFile(file));
        }
        else{
            return gson.toJson("no permission");
        }

    }*/
    @DeleteMapping(value = "/file" , produces = "application/json;charset=UTF-8")
    public String deleteFiles(HttpServletRequest request,
                              @CookieValue("userID") Integer UserID,
                              @CookieValue("userPassword") String UserPassword){
        Integer FileID = Integer.parseInt(request.getParameter("FileID"));
        Objects object = new Objects();
        Operation operation = new Operation();
        RBACService rbacService = new RBACService();
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

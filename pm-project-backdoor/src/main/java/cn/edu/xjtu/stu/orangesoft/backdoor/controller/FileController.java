package cn.edu.xjtu.stu.orangesoft.backdoor.controller;

import cn.edu.xjtu.stu.orangesoft.backdoor.core.DIUtil;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.RBACMapper;
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
    @Autowired
    RBACService rbacService;
    //TODO
    @GetMapping(value = "/file/{fileID}", produces = "application/json;charset=UTF-8")//等RBAC验证功能
    public String getFile(@PathVariable("fileID") Integer FileID,
                          @CookieValue("userID") String UserID,
                          @CookieValue("userPassword") String UserPassword) {
        Objects object = DIUtil.getBean(Objects.class);
        Operation operation = DIUtil.getBean(Operation.class);
        object.setObjectName("file");
        operation.setOperationDescription("GET");
        Integer userID = Integer.parseInt(UserID);
        if(rbacService.CheckPermission(userID, UserPassword, object, operation)){
            return gson.toJson(fileService.getFilesByID(FileID));
        }
        else{
            return gson.toJson("no permission");
        }
    }
    @GetMapping(value = "/file", produces = "application/json;charset=UTF-8")
    public String getFiles(HttpServletRequest request,
                               @CookieValue("userID") String UserID,
                               @CookieValue("userPassword") String UserPassword) {
        Integer userID = Integer.parseInt(UserID);
        Objects object = DIUtil.getBean(Objects.class);
        Operation operation = DIUtil.getBean(Operation.class);
        Integer TeamID = Integer.parseInt(request.getParameter("TeamID"));
        object.setObjectName("file");
        operation.setOperationDescription("GET");
        FileResult fileResult = DIUtil.getBean(FileResult.class);
        if(rbacService.CheckPermission(userID, UserPassword, object, operation)){
            return gson.toJson(fileService.getFileByTeamID(TeamID));
        }
        else{
            fileResult.setFinish("no permission");
            return gson.toJson(fileResult);
        }
    }
    @PostMapping(value = "/file" , produces = "application/json;charset=UTF-8")
    public String postFiles(HttpServletRequest request,
                            @RequestParam(name = "files") MultipartFile file,
                            @CookieValue("userID") String UserID,
                            @CookieValue("userPassword") String UserPassword) throws IOException {//具体怎么获取文件信息尚不清楚,fileassess？
        Objects object = DIUtil.getBean(Objects.class);
        Operation operation = DIUtil.getBean(Operation.class);
        object.setObjectName("file");
        operation.setOperationDescription("POST");
        Integer userID = Integer.parseInt(UserID);

        Files saveFile = new Files();
        saveFile.setFileRealName(file.getOriginalFilename());
        saveFile.setFileLocation(request.getSession().getServletContext().getRealPath("/"));
        int begin = file.getOriginalFilename().indexOf(".");
        int last = file.getOriginalFilename().length();
        saveFile.setFileType(file.getOriginalFilename().substring(begin, last));
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        saveFile.setUpLoadTime(df.format(date));
        saveFile.setStudentUserID(userID);
        Student student = studentMapper.GetStudentDataByUserID(userID);
        saveFile.setTeamID(student.getTeamID());
        byte [] bytes = file.getBytes();
        if(rbacService.CheckPermission(userID, UserPassword, object, operation)){
            String result = fileService.postFile(saveFile, bytes);
            return gson.toJson(result);
        }
        else{
         return gson.toJson("no permission");
        }
    }
    @PutMapping(value = "/file" , produces = "application/json;charset=UTF-8")
    public String putFiles(HttpServletRequest request,
                           @RequestParam(name = "files") MultipartFile file,
                           @CookieValue("userID") String UserID,
                           @CookieValue("userPassword") String UserPassword) throws IOException {
        Integer FileID = Integer.parseInt(request.getParameter("FileID"));

        Objects object = DIUtil.getBean(Objects.class);
        Operation operation = DIUtil.getBean(Operation.class);
        object.setObjectName("file");
        Integer userID = Integer.parseInt(UserID);
        operation.setOperationDescription("UPDATE");

        Files saveFile = new Files();
        saveFile.setFileRealName(file.getOriginalFilename());
        saveFile.setFileLocation(request.getSession().getServletContext().getRealPath("/"));
        saveFile.setFileType(file.getContentType());
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        saveFile.setUpLoadTime(df.format(date));
        saveFile.setStudentUserID(userID);
        Student student = studentMapper.GetStudentDataByUserID(userID);
        saveFile.setTeamID(student.getTeamID());
        saveFile.setFileID(FileID);
        byte [] bytes = file.getBytes();


        if(rbacService.CheckPermission(userID, UserPassword, object, operation)) {
            return gson.toJson(fileService.putFile(saveFile, bytes));
        }
        else{
            return gson.toJson("no permission");
        }

    }
    @DeleteMapping(value = "/file" , produces = "application/json;charset=UTF-8")
    public String deleteFiles(HttpServletRequest request,
                              @CookieValue("userID") String UserID,
                              @CookieValue("userPassword") String UserPassword){
        Integer FileID = Integer.parseInt(request.getParameter("FileID"));
        Objects object = DIUtil.getBean(Objects.class);
        Operation operation = DIUtil.getBean(Operation.class);
        object.setObjectName("File");
        operation.setOperationDescription("DELETE");
        Integer userID = Integer.parseInt(UserID);
        if(rbacService.CheckPermission(userID, UserPassword, object, operation)) {
            return gson.toJson(fileService.deleteFile(FileID));
        }
        else{
            return gson.toJson("no permission");
        }
    }
}

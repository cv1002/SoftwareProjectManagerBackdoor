package cn.edu.xjtu.stu.orangesoft.backdoor.controller;

import cn.edu.xjtu.stu.orangesoft.backdoor.core.DIUtil;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.StudentMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.*;
import cn.edu.xjtu.stu.orangesoft.backdoor.service.RBACService;
import cn.edu.xjtu.stu.orangesoft.backdoor.service.FileService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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

    @GetMapping(value = "/file/{FileID}", produces = "application/force-download;charset=UTF-8")
    public String getFileByFileID(HttpServletResponse response,
                                  @PathVariable("FileID") Integer fileID,
                                  @CookieValue("UserID") String userID,
                                  @CookieValue("UserPassword") String userPassword) {
        Objects object = DIUtil.getBean(Objects.class);
        Operation operation = DIUtil.getBean(Operation.class);
        object.setObjectName("file");
        operation.setOperationDescription("GET");

        ResultInfo resultInfo = DIUtil.getBean(ResultInfo.class);
        if (rbacService.CheckPermission(Integer.valueOf(userID), userPassword, object, operation)) {
            FileResult fileResult = fileService.getFileByFileID(fileID);
            FileContent fileContent = fileResult.getFileContents().get(0);
            FileInfo fileInfo = fileResult.getFiles().get(0);

            byte[] buffer = new byte[1024];
            response.setContentType("application/force-download");
            response.addHeader("Content-Disposition", "attachment;filename=" + fileInfo.getFileRealName());

            String len = String.valueOf(fileContent.getFileContent().length);
            response.setHeader("Content-Length", len);
            try (OutputStream out = response.getOutputStream();
                 InputStream in = new ByteArrayInputStream(fileContent.getFileContent())) {
                int iter;
                while ((iter = in.read(buffer)) != -1) {
                    out.write(buffer, 0, iter);
                }
            } catch (IOException e) {
                e.printStackTrace();
                resultInfo.setResultInfo("文件上传失败！！");
            }
        } else {
            resultInfo.setResultInfo("无权访问！！");
        }
        return gson.toJson(resultInfo);
    }

    @GetMapping(value = "/files", produces = "application/json;charset=UTF-8")
    public String getFileInfosByTeamID(HttpServletRequest request,
                                       @CookieValue("userID") String UserID,
                                       @CookieValue("userPassword") String UserPassword) {
        int userID = Integer.parseInt(UserID);
        Objects object = DIUtil.getBean(Objects.class);
        Operation operation = DIUtil.getBean(Operation.class);
        int TeamID = Integer.parseInt(request.getParameter("TeamID"));
        object.setObjectName("file");
        operation.setOperationDescription("GET");

        FileResult fileResult = DIUtil.getBean(FileResult.class);
        if (rbacService.CheckPermission(userID, UserPassword, object, operation)) {
            return gson.toJson(fileService.getFileByTeamID(TeamID));
        } else {
            fileResult.setFinish("no permission");
            return gson.toJson(fileResult);
        }
    }

    @DeleteMapping(path = "/file", produces = "application/json;charset=UTF-8")
    public String deleteFile(@RequestParam("FileID") Integer FileID,
                             @CookieValue("UserID") String UserID,
                             @CookieValue("UserPassword") String UserPassword) {
        Operation operation = DIUtil.getBean(Operation.class);
        Objects objects = DIUtil.getBean(Objects.class);
        operation.setOperationDescription("DELETE");
        objects.setObjectName("file");

        if (rbacService.CheckPermission(Integer.valueOf(UserID), UserPassword, objects, operation)) {
            return gson.toJson(fileService.deleteFile(FileID));
        } else {
            ResultInfo resultInfo = DIUtil.getBean(ResultInfo.class);
            resultInfo.setResultInfo("无权访问！！");
            return gson.toJson(resultInfo);
        }
    }

    @PutMapping(path = "/file", produces = "application/json;charset=UTF-8")
    public String putFile(HttpServletRequest request,
                          @RequestParam(name = "files") MultipartFile file,
                          @CookieValue("UserID") String UserID,
                          @CookieValue("UserPassword") String UserPassword) {
        Objects object = DIUtil.getBean(Objects.class);
        Operation operation = DIUtil.getBean(Operation.class);
        object.setObjectName("file");
        Integer userID = Integer.parseInt(UserID);
        operation.setOperationDescription("PUT");

        if (rbacService.CheckPermission(userID, UserPassword, object, operation)) {
            int fileID = Integer.parseInt(request.getParameter("FileID"));
            return gson.toJson(fileService.putFile(Integer.valueOf(UserID), fileID, file));
        } else {
            ResultInfo resultInfo = DIUtil.getBean(ResultInfo.class);
            resultInfo.setResultInfo("无权访问！！");
            return gson.toJson(resultInfo);
        }
    }

    public String postFile(HttpServletRequest request,
                           @RequestParam(name = "files") MultipartFile file,
                           @CookieValue("UserID") String userID,
                           @CookieValue("UserPassword") String userPassword) {
        Objects objects = DIUtil.getBean(Objects.class);
        Operation operation = DIUtil.getBean(Operation.class);
        objects.setObjectName("file");
        operation.setOperationDescription("POST");

        if (rbacService.CheckPermission(Integer.valueOf(userID), userPassword, objects, operation)) {
            return gson.toJson(fileService.postFile(Integer.valueOf(userID), file));
        } else {
            ResultInfo resultInfo = DIUtil.getBean(ResultInfo.class);
            resultInfo.setResultInfo("无权访问！！");
            return gson.toJson(resultInfo);
        }
    }
}

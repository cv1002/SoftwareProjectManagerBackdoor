package cn.edu.xjtu.stu.orangesoft.backdoor.controller;

import cn.edu.xjtu.stu.orangesoft.backdoor.core.DIUtil;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.StudentMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.*;
import cn.edu.xjtu.stu.orangesoft.backdoor.service.FileService;
import cn.edu.xjtu.stu.orangesoft.backdoor.service.RBACService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@RestController
@CrossOrigin
public class FileController {
    @Autowired
    FileService fileService;
    @Autowired
    Gson gson;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    RBACService rbacService;

    /**
     * 根据文件ID获取文件
     *
     * @param response     用于传输文件的HTTPServletResponse
     * @param fileID       需要获取的文件
     * @param userID       用户ID，用于RBAC
     * @param userPassword 用户密码，用于RBAC
     * @return if (文件不存在 || 无权访问 || IOException) return ResultInfo: {
     * "resultInfo": String
     * } else {
     * BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
     * out.write(file);
     * }
     */
    @GetMapping(value = "/file/{FileID}", produces = "application/json;charset=UTF-8")
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

            // 设置Header里应该带有的文件长度
            response.setHeader("Content-Length",
                    String.valueOf(fileContent.getFileContent().length));
            // 这里使用自带buffer的OutputStream，默认buffer大小为8192Bytes，也就是8kB
            try (BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
                 InputStream in = new ByteArrayInputStream(fileContent.getFileContent())) {
                response.setContentType("application/force-download");
                // 设置文件名，需要改成UTF-8格式
                response.addHeader("Content-Disposition",
                        "attachment;filename=" + URLEncoder.encode(fileInfo.getFileRealName(), "UTF-8"));
                // 读取文件并返回，这里使用InputStream偷懒
                int buf;
                while ((buf = in.read()) != -1) {
                    out.write(buf);
                }
            } catch (IOException e) {
                e.printStackTrace();
                resultInfo.setResultInfo("文件下载失败！！");
            }
        } else {
            resultInfo.setResultInfo("无权访问！！");
        }
        return gson.toJson(resultInfo);
    }

    /**
     * 获取整个队伍的文档列表
     *
     * @param TeamID       队伍ID
     * @param UserID       用户ID，用于RBAC
     * @param UserPassword 用户密码，用于RBAC
     * @return FileResult: {
     * "files": List[FileInfo],
     * "fileContents": null,
     * "Finish": String
     * }
     */
    @GetMapping(value = "/files", produces = "application/json;charset=UTF-8")
    public String getFileInfosByTeamID(@RequestParam("TeamID") Integer TeamID,
                                       @CookieValue("userID") String UserID,
                                       @CookieValue("userPassword") String UserPassword) {
        int userID = Integer.parseInt(UserID);
        Objects object = DIUtil.getBean(Objects.class);
        Operation operation = DIUtil.getBean(Operation.class);
        object.setObjectName("file");
        operation.setOperationDescription("GET");

        FileResult fileResult = DIUtil.getBean(FileResult.class);
        if (rbacService.CheckPermission(userID, UserPassword, object, operation)) {
            return gson.toJson(fileService.getFileByTeamID(TeamID));
        } else {
            fileResult.setFinish("无权访问！！");
            return gson.toJson(fileResult);
        }
    }

    /**
     * 删除文件
     *
     * @param FileID       被删除的文件的ID
     * @param UserID       用户名，用于RBAC
     * @param UserPassword 用户密码，用于RBAC
     * @return ResultInfo: {
     * "resultInfo": String
     * }
     */
    @DeleteMapping(path = "/file", produces = "application/json;charset=UTF-8")
    public String deleteFile(@RequestParam("FileID") Integer FileID,
                             @RequestParam("UserID") String UserID,
                             @RequestParam("UserPassword") String UserPassword) {
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

    /**
     * 更新文件
     *
     * @param fileID       被更新的文档的ID
     * @param file         文件本体
     * @param UserID       用户名，用于RBAC
     * @param UserPassword 用户密码，用于RBAC
     * @return ResultInfo: {
     * "resultInfo": String
     * }
     */
    @PutMapping(path = "/file", produces = "application/json;charset=UTF-8")
    public String putFile(@RequestParam("FileID") Integer fileID,
                          @RequestParam("files") MultipartFile file,
                          @RequestParam("UserID") String UserID,
                          @RequestParam("UserPassword") String UserPassword) {
        Objects object = DIUtil.getBean(Objects.class);
        Operation operation = DIUtil.getBean(Operation.class);
        object.setObjectName("file");
        Integer userID = Integer.parseInt(UserID);
        operation.setOperationDescription("PUT");

        if (rbacService.CheckPermission(userID, UserPassword, object, operation)) {
            return gson.toJson(fileService.putFile(Integer.valueOf(UserID), fileID, file));
        } else {
            ResultInfo resultInfo = DIUtil.getBean(ResultInfo.class);
            resultInfo.setResultInfo("无权访问！！");
            return gson.toJson(resultInfo);
        }
    }

    /**
     * 上传文件
     *
     * @param file         文件本体
     * @param userID       用户名，用于RBAC
     * @param userPassword 用户名，用于RBAC
     * @return ResultInfo: {
     * "resultInfo": String
     * }
     */
    @PostMapping(path = "/file", produces = "application/json;charset=UTF-8")
    public String postFile(@RequestParam("files") MultipartFile file,
                           @RequestParam("UserID") String userID,
                           @RequestParam("UserPassword") String userPassword) {
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

package cn.edu.xjtu.stu.orangesoft.backdoor.controller;

import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Files;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Objects;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Operation;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.ResultInfo;
import cn.edu.xjtu.stu.orangesoft.backdoor.service.FileAssessService;
import cn.edu.xjtu.stu.orangesoft.backdoor.service.RBACService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FileAssessController {
    @Autowired
    FileAssessService fileAssessService;
    @Autowired
    RBACService rbacService;
    @Autowired
    Gson gson;

    @GetMapping(value = "/fileAccess", produces = "application/json;charset=UTF-8")
    public String FindFileAssessByFileID(@RequestParam(name = "FileID") Integer fileID,
                                         @CookieValue(value = "UserID", defaultValue = "0") Integer UserID,
                                         @CookieValue(value = "UserPassword", defaultValue = "") String UserPassword) {
        Operation operation = new Operation();
        Objects objects = new Objects();
        ResultInfo resultInfo = new ResultInfo();
        operation.setOperationDescription("GET");
        objects.setObjectName("fileAssess");
        if (rbacService.CheckPermission(UserID, UserPassword, objects, operation)) {
            if (fileAssessService.FindFileAssessByFileID(fileID) == null) {
                resultInfo.setResultInfo("文件无评价！！");
                return gson.toJson(resultInfo);
            } else {
                return gson.toJson(fileAssessService.FindFileAssessByFileID(fileID));
            }
        } else {
            resultInfo.setResultInfo("无权访问!!");
            return gson.toJson(resultInfo);
        }
    }

    @PostMapping(value = "/fileAccess", produces = "application/json;charset=UTF-8")
    public String BulidNewFileAssess(@RequestParam(value = "UserID", defaultValue = "0") Integer UserID,
                                     @RequestParam(value = "UserPassword", defaultValue = "") String UserPassword,
                                     @RequestParam(name = "Assess") String assess,
                                     @RequestParam(name = "Files") Files files) {
        Operation operation = new Operation();
        Objects objects = new Objects();
        ResultInfo resultInfo = new ResultInfo();
        operation.setOperationDescription("POST");
        objects.setObjectName("fileAssess");
        if (rbacService.CheckPermission(UserID, UserPassword, objects, operation)) {
            resultInfo.setResultInfo(gson.toJson(fileAssessService.BulidNewFileAssess(files, UserID, assess)));
        } else {
            resultInfo.setResultInfo("无权评价！！");
        }
        return gson.toJson(resultInfo);
    }
}

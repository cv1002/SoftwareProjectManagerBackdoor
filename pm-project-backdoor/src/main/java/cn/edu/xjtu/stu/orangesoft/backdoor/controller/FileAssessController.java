package cn.edu.xjtu.stu.orangesoft.backdoor.controller;

import cn.edu.xjtu.stu.orangesoft.backdoor.core.DIUtil;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.FileInfo;
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

    /**
     * 查看单个文件的评价
     *
     * @param fileID       查询的文件的ID
     * @param UserID       用户ID，用于RBAC
     * @param UserPassword 用户的密码，用于RBAC
     * @return if (无权访问 || 文件无评价) return ResultInfo: {
     * "resultInfo": String
     * } else return FileAssess: {
     * "FileID": int,
     * "FileAssess": String,
     * "AssessorID": int,
     * "AssessTime": String
     * }
     */
    @GetMapping(value = "/fileAccess", produces = "application/json;charset=UTF-8")
    public String FindFileAssessByFileID(@RequestParam(name = "FileID") Integer fileID,
                                         @CookieValue(value = "UserID", defaultValue = "0") Integer UserID,
                                         @CookieValue(value = "UserPassword", defaultValue = "") String UserPassword) {
        Operation operation = DIUtil.getBean(Operation.class);
        Objects objects = DIUtil.getBean(Objects.class);
        ResultInfo resultInfo = DIUtil.getBean(ResultInfo.class);
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

    /**
     * 更新文件评价
     *
     * @param UserID       用户名，用于RBAC
     * @param UserPassword 用户密码，用于RBAC
     * @param assess       评价，用于更新评价
     * @param fileInfo     文件信息，用于确定更新哪个文件的评价
     * @return ResultInfo: {
     * "resultInfo": String
     * }
     */
    @PostMapping(value = "/fileAccess", produces = "application/json;charset=UTF-8")
    public String BuildNewFileAssess(@RequestParam(value = "UserID", defaultValue = "0") Integer UserID,
                                     @RequestParam(value = "UserPassword", defaultValue = "") String UserPassword,
                                     @RequestParam(name = "Assess") String assess,
                                     @RequestParam(name = "fileInfo") FileInfo fileInfo) {
        Operation operation = DIUtil.getBean(Operation.class);
        Objects objects = DIUtil.getBean(Objects.class);
        ResultInfo resultInfo = DIUtil.getBean(ResultInfo.class);
        operation.setOperationDescription("POST");
        objects.setObjectName("fileAssess");
        if (rbacService.CheckPermission(UserID, UserPassword, objects, operation)) {
            resultInfo.setResultInfo(gson.toJson(fileAssessService.BuildNewFileAssess(fileInfo, UserID, assess)));
        } else {
            resultInfo.setResultInfo("无权评价！！");
        }
        return gson.toJson(resultInfo);
    }
}

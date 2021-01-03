package cn.edu.xjtu.stu.orangesoft.backdoor.controller;

import cn.edu.xjtu.stu.orangesoft.backdoor.core.DIUtil;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Objects;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Operation;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.ResultInfo;
import cn.edu.xjtu.stu.orangesoft.backdoor.service.CommunicationService;
import cn.edu.xjtu.stu.orangesoft.backdoor.service.RBACService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CommunicationController {
    @Autowired
    CommunicationService communicationService;
    @Autowired
    RBACService rbacService;
    @Autowired
    Gson gson;

    /**
     * 查看交流信息
     *
     * @param UserID       账号
     * @param UserPassword 密码
     * @param TeamID       小组ID
     * @return if (无权访问) return ResultInfo: {
     * "resultInfo": String
     * } else return List[String]
     */
    @PostMapping(value = "/get/communication", produces = "application/json;charset=UTF-8")
    public String GetCommunication(@RequestParam("UserID") Integer UserID,
                                   @RequestParam("UserPassword") String UserPassword,
                                   @RequestParam("TeamID") Integer TeamID) {
        Objects objects = DIUtil.getBean(Objects.class);
        Operation operation = DIUtil.getBean(Operation.class);
        objects.setObjectName("communication");
        operation.setOperationDescription("GET");
        if (rbacService.CheckPermission(UserID, UserPassword, objects, operation)) {
            return gson.toJson(communicationService.GetCommunication(TeamID));
        } else {
            ResultInfo resultInfo = DIUtil.getBean(ResultInfo.class);
            resultInfo.setResultInfo("无权访问！！");
            return gson.toJson(resultInfo);
        }
    }

    /**
     * 发送交流信息
     *
     * @param UserID       账号
     * @param UserPassword 密码
     * @param TeamID       小组ID
     * @param Context      交流内容
     * @param FileID       文件ID（nullable）
     * @return ResultInfo: {
     * "resultInfo": String
     * }
     */
    @PostMapping(value = "/communication", produces = "application/json;charset=UTF-8")
    public String PostCommunicationWithoutFileID(@RequestParam("UserID") Integer UserID,
                                    @RequestParam("UserPassword") String UserPassword,
                                    @RequestParam("TeamID") Integer TeamID,
                                    @RequestParam("Context") String Context,
                                    @RequestParam(value = "FileID") Integer FileID) {
        Objects objects = DIUtil.getBean(Objects.class);
        Operation operation = DIUtil.getBean(Operation.class);
        ResultInfo resultInfo;
        objects.setObjectName("communication");
        operation.setOperationDescription("POST");
        if (rbacService.CheckPermission(UserID, UserPassword, objects, operation)) {
            resultInfo = communicationService.PostCommunication(UserID, TeamID, Context, null);
        } else {
            resultInfo = DIUtil.getBean(ResultInfo.class);
            resultInfo.setResultInfo("无权访问！！");
        }
        return gson.toJson(resultInfo);
    }

    /**
     * 发送交流信息
     *
     * @param UserID       账号
     * @param UserPassword 密码
     * @param TeamID       小组ID
     * @param Context      交流内容
     * @param FileID       文件ID（nullable）
     * @return ResultInfo: {
     * "resultInfo": String
     * }
     */
    @PostMapping(value = "/communication/{FileID}", produces = "application/json;charset=UTF-8")
    public String PostCommunication(@RequestParam("UserID") Integer UserID,
                                    @RequestParam("UserPassword") String UserPassword,
                                    @RequestParam("TeamID") Integer TeamID,
                                    @RequestParam("Context") String Context,
                                    @PathVariable("FileID") Integer FileID) {
        Objects objects = DIUtil.getBean(Objects.class);
        Operation operation = DIUtil.getBean(Operation.class);
        ResultInfo resultInfo;
        objects.setObjectName("communication");
        operation.setOperationDescription("POST");
        if (rbacService.CheckPermission(UserID, UserPassword, objects, operation)) {
            resultInfo = communicationService.PostCommunication(UserID, TeamID, Context, FileID);
        } else {
            resultInfo = DIUtil.getBean(ResultInfo.class);
            resultInfo.setResultInfo("无权访问！！");
        }
        return gson.toJson(resultInfo);
    }
}

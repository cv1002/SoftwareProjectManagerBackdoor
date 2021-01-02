package cn.edu.xjtu.stu.orangesoft.backdoor.controller;

import cn.edu.xjtu.stu.orangesoft.backdoor.core.DIUtil;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Objects;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Operation;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.ResultInfo;
import cn.edu.xjtu.stu.orangesoft.backdoor.service.RBACService;
import cn.edu.xjtu.stu.orangesoft.backdoor.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    RBACService rbacService;
    @Autowired
    Gson gson;

    @PostMapping(value = "/get/todoList", produces = "application/json;charset=UTF-8")
    public String GetTodoListByUserID(@RequestParam("UserID") Integer UserID,
                                      @RequestParam("UserPassword") String UserPassword) {
        Operation operation = DIUtil.getBean(Operation.class);
        Objects objects = DIUtil.getBean(Objects.class);
        ResultInfo resultInfo = DIUtil.getBean(ResultInfo.class);
        operation.setOperationDescription("GET");
        objects.setObjectName("todoList");
        if (rbacService.CheckPermission(UserID, UserPassword, objects, operation)) {
            return gson.toJson(userService.GetTodoListByUserID(UserID));
        } else {
            resultInfo.setResultInfo("无权访问!!");
            return gson.toJson(resultInfo);
        }
    }

    @PostMapping(value = "/get/lastLogin", produces = "application/json;charset=UTF-8")
    public String GetLastLoginInfo(@RequestParam("UserID") Integer UserID,
                                   @RequestParam("UserPassword") String UserPassword){
        Operation operation = DIUtil.getBean(Operation.class);
        Objects objects = DIUtil.getBean(Objects.class);
        ResultInfo resultInfo = DIUtil.getBean((ResultInfo.class));
        operation.setOperationDescription("GET");
        objects.setObjectName("LastLogin");
        if(rbacService.CheckPermission(UserID,UserPassword,objects,operation)){
            return gson.toJson(userService.GetLastLoginInfo(UserID));
        } else {
            resultInfo.setResultInfo("无权访问!!");
            return gson.toJson(resultInfo);
        }
    }
}

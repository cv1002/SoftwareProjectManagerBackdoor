package cn.edu.xjtu.stu.orangesoft.backdoor.controller;

import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.LoginResult;
import cn.edu.xjtu.stu.orangesoft.backdoor.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    LoginService loginService;

    /**
     * LoginController 负责Login方面的URL引导
     *
     * @param UserID       用户ID，用于RBAC
     * @param UserPassword 用户密码，用于RBAC
     * @return LoginResult: {
     * "Finish": String,
     * "LoginType": String,
     * "TeamID": Integer,
     * "TeamName": String,
     * "RoleName": String
     * }
     */
    @PostMapping(value = "/login", produces = "application/json;charset=UTF-8")
    public LoginResult login(@RequestParam(name = "UserID") String UserID,
                             @RequestParam(name = "UserPassword") String UserPassword) {
        return loginService.login(Integer.valueOf(UserID), UserPassword);
    }
}

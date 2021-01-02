package cn.edu.xjtu.stu.orangesoft.backdoor.controller;

import cn.edu.xjtu.stu.orangesoft.backdoor.core.DIUtil;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.LastLogin;
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
     * @param LastLoginDate 当前登录日期
     * @param LastLoginPlace 当前登陆地点
     * @return LoginResult: {
     * "Finish": String,
     * "LoginType": String,
     * "TeamID": Integer,
     * "TeamName": String,
     * "RoleName": String
     * }
     */
    @PostMapping(value = "/login", produces = "application/json;charset=UTF-8")
    public LoginResult login(@RequestParam("UserID") int UserID,
                             @RequestParam("UserPassword") String UserPassword,
                             @RequestParam("LastLoginDate") String LastLoginDate,
                             @RequestParam("LastLoginPlcae") String LastLoginPlace) {
        LastLogin lastLogin = DIUtil.getBean(LastLogin.class);
        lastLogin.setUserID(UserID);
        lastLogin.setLastLoginDate(LastLoginDate);
        lastLogin.setLastLoginPlace(LastLoginPlace);
        loginService.refreshLastLogin(lastLogin);
        return loginService.login(Integer.valueOf(UserID), UserPassword);
    }
}

package cn.edu.xjtu.stu.orangesoft.backdoor.controller;

import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.LoginResult;
import cn.edu.xjtu.stu.orangesoft.backdoor.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    // TODO 半成品
    @PostMapping(value = "/login", produces = "application/json;charset=UTF-8")
    public LoginResult login(@RequestParam(name = "UserID") Integer UserID,
                             @RequestParam(name = "UserPassword") String UserPassword) {
        return loginService.login(UserID, UserPassword);
    }
}

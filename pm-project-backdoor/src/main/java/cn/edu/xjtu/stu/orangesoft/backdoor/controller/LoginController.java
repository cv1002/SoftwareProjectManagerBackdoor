package cn.edu.xjtu.stu.orangesoft.backdoor.controller;

import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.*;
import cn.edu.xjtu.stu.orangesoft.backdoor.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    // TODO 半成品
    @PostMapping(value = "/login", produces = "application/json;charset=UTF-8")
    public Login login(@RequestParam Integer UserID, @RequestParam String UserPassword) {
        return loginService.login(UserID, UserPassword);
    }
}

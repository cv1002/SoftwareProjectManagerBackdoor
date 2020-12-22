package cn.edu.xjtu.stu.orangesoft.backdoor.controller;

import cn.edu.xjtu.stu.orangesoft.backdoor.bean.User;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/testBOOT")
public class UserController {
    //autowired注解表示自动生成对象，报错不用管
    //有问题就new对象
    @Autowired
    private UserMapper usermapper;

    //注解标记方法类型（postMapping,getMapping等），value是URl，花括号中对应参数，用PathVariable引入。produces= content-type/json
    //加了/json会自动转换为json
    @GetMapping(value = "/login/{UserID}/{UserPassword}", produces = "application/json;charset=UTF-8")
    public User GetUserByIDAndPassword(@PathVariable("UserID") Integer id, @PathVariable("UserPassword") String password) {
        return usermapper.GetUserByIDAndPassword(id, password);
    }
}
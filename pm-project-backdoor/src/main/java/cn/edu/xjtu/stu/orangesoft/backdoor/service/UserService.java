package cn.edu.xjtu.stu.orangesoft.backdoor.service;

import cn.edu.xjtu.stu.orangesoft.backdoor.bean.User;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User GetUserByID(Integer UserID, String UserPassword) {
        return userMapper.GetUserByIDAndPassword(UserID, UserPassword);
    }
}

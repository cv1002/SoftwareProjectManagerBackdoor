package cn.edu.xjtu.stu.orangesoft.backdoor.service;

import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.RBACMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.UserMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.*;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RBACService {
    @Autowired
    RBACMapper rbacMapper;
    @Autowired
    UserMapper userMapper;

    public boolean CheckPermission(Integer userID, String userPassword, Object object, Operation operation) {
        User user = userMapper.GetUserByIDAndPassword(userID, userPassword);
        return CheckPermission(user.getRoleID(), object, operation);
    }
    public boolean CheckPermission(Integer roleID, Object object, Operation operation) {
        PermissionConfig config = rbacMapper.CheckPermission(roleID, object, operation);
        return config.getPermission() != 0;
    }
}

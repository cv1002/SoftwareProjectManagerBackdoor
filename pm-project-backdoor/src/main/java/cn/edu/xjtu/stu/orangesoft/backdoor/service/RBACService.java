package cn.edu.xjtu.stu.orangesoft.backdoor.service;

import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.RBACMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.UserMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RBACService {
    @Autowired
    RBACMapper rbacMapper;
    @Autowired
    UserMapper userMapper;

    public boolean CheckPermission(Integer userID, String userPassword, Objects objects, Operation operation) {
        User user = userMapper.GetUserByIDAndPassword(userID, userPassword);
        return user != null && CheckPermission(user.getRoleID(), objects, operation);
    }

    public boolean CheckPermission(Integer roleID, Objects objects, Operation operation) {
        RolePowerAssignment assignment = rbacMapper.CheckPermission(roleID, objects.getObjectName(), operation.getOperationDescription());
        return assignment != null && assignment.getPermission() != 0;
    }
}

package cn.edu.xjtu.stu.orangesoft.backdoor.service;

import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.RBACMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Object;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Operation;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.PermissionConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RBACService {
    @Autowired
    RBACMapper rbacMapper;

    public boolean CheckPermission(Object object, Operation operation) {
        PermissionConfig config = rbacMapper.CheckPermission(object, operation);
        return config.getPermission() != 0;
    }
}

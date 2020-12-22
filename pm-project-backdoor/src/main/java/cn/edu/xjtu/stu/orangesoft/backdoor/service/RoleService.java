package cn.edu.xjtu.stu.orangesoft.backdoor.service;

import cn.edu.xjtu.stu.orangesoft.backdoor.bean.Role;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleMapper roleMapper;

    public Role Sel(Integer RoleID){
        return roleMapper.Sel(RoleID);
    }
}

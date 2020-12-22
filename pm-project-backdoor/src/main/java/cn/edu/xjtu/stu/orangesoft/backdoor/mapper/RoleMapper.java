package cn.edu.xjtu.stu.orangesoft.backdoor.mapper;

import cn.edu.xjtu.stu.orangesoft.backdoor.bean.Role;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    Role GetRoleByID(@Param("id") Integer RoleID);
}

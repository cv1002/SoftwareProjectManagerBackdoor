package cn.edu.xjtu.stu.orangesoft.backdoor.mapper;

import cn.edu.xjtu.stu.orangesoft.backdoor.bean.Role;
import org.apache.ibatis.annotations.Select;

public interface RoleMapper {
    Role Sel(Integer RoleID);
}

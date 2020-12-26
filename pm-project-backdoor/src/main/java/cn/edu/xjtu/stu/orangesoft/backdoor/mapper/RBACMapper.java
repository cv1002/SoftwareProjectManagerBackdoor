package cn.edu.xjtu.stu.orangesoft.backdoor.mapper;

import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.PermissionConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RBACMapper {
    List<PermissionConfig> GetPermissionConfigsByRoleID(@Param("RoleID") Integer RoleID);

    PermissionConfig CheckPermission(@Param("RoleID") Integer roleID,
                                     @Param("Object") String objects,
                                     @Param("Operation") String operation);
}

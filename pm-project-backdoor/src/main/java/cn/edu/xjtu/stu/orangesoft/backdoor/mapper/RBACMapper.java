package cn.edu.xjtu.stu.orangesoft.backdoor.mapper;

import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.RBACQueryResult;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.RolePowerAssignment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RBACMapper {
    List<RBACQueryResult> GetAssignmentConfigsByRoleID(@Param("RoleID") Integer RoleID);

    RolePowerAssignment CheckPermission(@Param("RoleID") Integer roleID,
                                        @Param("Object") String objects,
                                        @Param("Operation") String operation);
}

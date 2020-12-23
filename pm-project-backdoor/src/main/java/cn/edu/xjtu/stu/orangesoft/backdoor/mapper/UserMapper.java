package cn.edu.xjtu.stu.orangesoft.backdoor.mapper;


import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.User;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {
    User GetUserByIDAndPassword(@Param("id") Integer UserID,
                                @Param("password") String UserPassword);
}

package cn.edu.xjtu.stu.orangesoft.backdoor.mapper;


import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    User GetUserByIDAndPassword(@Param("id") Integer UserID,
                                @Param("password") String UserPassword);

    User GetUserByUserID(@Param("id") Integer UserID);

}

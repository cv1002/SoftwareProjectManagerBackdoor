package cn.edu.xjtu.stu.orangesoft.backdoor.mapper;

import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.LastLogin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LastLoginMapper {
    LastLogin GetLastLoginInfo(Integer UserID);
    void refreshLastLogin(LastLogin lastLogin);
}

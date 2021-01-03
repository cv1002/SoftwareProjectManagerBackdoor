package cn.edu.xjtu.stu.orangesoft.backdoor.mapper;


import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Communication;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommunicationMapper {
    List<Communication> GetCommunication(@Param("TeamID") Integer TeamID);

    List<Communication> GetAllCommunication();

    int PostCommunication(@Param("Communication") Communication Communication);

}

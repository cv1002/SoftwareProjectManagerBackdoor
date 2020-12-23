package cn.edu.xjtu.stu.orangesoft.backdoor.mapper;

import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Student;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
    Student GetStudentDataByUserID(@Param("id") Integer UserID);
}

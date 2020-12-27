package cn.edu.xjtu.stu.orangesoft.backdoor.mapper;

import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.StudentAssess;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository

public interface StudentAssessMapper {
    StudentAssess GetStudentScoreByStudentID(
            @Param("StudentUserid") Integer StudentUserID);

    Integer BuildNewStudentAssess(StudentAssess studentAssess);
}

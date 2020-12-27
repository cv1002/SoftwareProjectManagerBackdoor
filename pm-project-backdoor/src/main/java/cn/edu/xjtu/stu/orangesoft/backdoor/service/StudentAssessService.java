package cn.edu.xjtu.stu.orangesoft.backdoor.service;

import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.StudentAssessMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.UserMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.ResultInfo;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Student;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.StudentAssess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentAssessService {
    @Autowired
    StudentAssessMapper studentAssessMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    RBACService rbacService;
    @Autowired
    ResultInfo resultInfo;
    @Autowired
    StudentAssess studentAssess;

    public StudentAssess FindStudentScoreByStudentID(Integer TeamID) {
        return studentAssessMapper.GetStudentScoreByStudentID(TeamID);
    }

    public ResultInfo BuildNewStudentAssess(Student student, Integer UserID, String Assess, Integer Score) {
        studentAssess.setAssess(Assess);
        studentAssess.setAssessorID(UserID);
        studentAssess.setStudentUserID(student.getStudentUserID());
        studentAssess.setScore(Score);
        studentAssessMapper.BuildNewStudentAssess(studentAssess);
        if (studentAssess.getStudentUserID() != 0) {
            resultInfo.setResultInfo("成功！！");
        }
        return resultInfo;
    }
}

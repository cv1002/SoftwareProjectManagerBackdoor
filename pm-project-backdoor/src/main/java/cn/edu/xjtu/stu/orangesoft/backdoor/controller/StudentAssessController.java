package cn.edu.xjtu.stu.orangesoft.backdoor.controller;

import cn.edu.xjtu.stu.orangesoft.backdoor.core.DIUtil;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Objects;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Operation;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.ResultInfo;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Student;
import cn.edu.xjtu.stu.orangesoft.backdoor.service.RBACService;
import cn.edu.xjtu.stu.orangesoft.backdoor.service.StudentAssessService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class StudentAssessController {
    @Autowired
    StudentAssessService studentAssessService;
    @Autowired
    RBACService rbacService;
    @Autowired
    Gson gson;

    /**
     * 根据StudentUserID获取Score
     *
     * @param StudentUserID 用户的UserID
     * @param UserID        用户ID，用于RBAC
     * @param UserPassword  用户密码，用于RBAC
     * @return if (无评分 || 无权访问) return ResultInfo: {
     * "resultInfo": String
     * } else return StudentAssess {
     * "Score": int,
     * "Assess": String,
     * "StudentUserID": int,
     * "AssessorID": int
     * }
     */
    @PostMapping(value = "/get/studentAssess", produces = "application/json;charset=UTF-8")
    public String FindStudentScoreByStudentID(@RequestParam("StudentUserID") Integer StudentUserID,
                                              @RequestParam("UserID") Integer UserID,
                                              @RequestParam("UserPassword") String UserPassword) {
        Operation operation = DIUtil.getBean(Operation.class);
        Objects objects = DIUtil.getBean(Objects.class);
        ResultInfo resultInfo = DIUtil.getBean(ResultInfo.class);
        operation.setOperationDescription("GET");
        objects.setObjectName("studentAssess");
        if (rbacService.CheckPermission(UserID, UserPassword, objects, operation)) {
            if (studentAssessService.FindStudentScoreByStudentID(StudentUserID) == null) {
                resultInfo.setResultInfo("学生无评分！！");
                return gson.toJson(resultInfo);
            } else {
                return gson.toJson(studentAssessService.FindStudentScoreByStudentID(StudentUserID));
            }
        } else {
            resultInfo.setResultInfo("无权访问!!");
            return gson.toJson(resultInfo);
        }
    }

    /**
     * 发表新的对学生的评价
     *
     * @param UserID        用户ID，用于RBAC
     * @param UserPassword  用户密码，用于RBAC
     * @param assess        评价内容
     * @param score         评价分数
     * @param StudentUserID 评价学生对象
     * @param StudentClass  对象学生班级
     * @param StudentID     对象学生学号
     * @param TeamID        对象学生所在小组ID
     * @param Job           对象学生分工
     * @return ResultInfo {
     * "resultInfo": String
     * }
     */
    @PostMapping(value = "/studentAssess", produces = "application/json;charset=UTF-8")
    public String BuildNewStudentAssess(@RequestParam("UserID") Integer UserID,
                                        @RequestParam("UserPassword") String UserPassword,
                                        @RequestParam("Assess") String assess,
                                        @RequestParam("Score") Integer score,
                                        @RequestParam("StudentUserID") int StudentUserID,
                                        @RequestParam("StudentClass") String StudentClass,
                                        @RequestParam("StudentID") long StudentID,
                                        @RequestParam("TeamID") int TeamID,
                                        @RequestParam("Job") String Job) {
        Operation operation = DIUtil.getBean(Operation.class);
        Objects objects = DIUtil.getBean(Objects.class);
        ResultInfo resultInfo = DIUtil.getBean(ResultInfo.class);
        operation.setOperationDescription("POST");
        objects.setObjectName("studentAssess");
        if (rbacService.CheckPermission(UserID, UserPassword, objects, operation)) {
            Student student = DIUtil.getBean(Student.class);
            student.setStudentUserID(StudentUserID);
            student.setStudentClass(StudentClass);
            student.setStudentID(StudentID);
            student.setTeamID(TeamID);
            student.setJob(Job);
            resultInfo.setResultInfo(gson.toJson(studentAssessService.BuildNewStudentAssess(student, UserID, assess, score)));
        } else {
            resultInfo.setResultInfo("无权访问！！");
        }
        return gson.toJson(resultInfo);
    }
}

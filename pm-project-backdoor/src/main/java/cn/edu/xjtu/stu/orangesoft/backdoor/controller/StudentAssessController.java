package cn.edu.xjtu.stu.orangesoft.backdoor.controller;

import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Objects;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Operation;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.ResultInfo;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Student;
import cn.edu.xjtu.stu.orangesoft.backdoor.service.RBACService;
import cn.edu.xjtu.stu.orangesoft.backdoor.service.StudentAssessService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentAssessController {
    @Autowired
    StudentAssessService studentAssessService;
    @Autowired
    RBACService rbacService;
    @Autowired
    Gson gson;

    @GetMapping(value = "/studentAssess", produces = "application/json;charset=UTF-8")
    public String FindStudentScoreByStudentID(@RequestParam(name = "StudentUserID") Integer StudentUserID,
                                              @CookieValue(value = "UserID", defaultValue = "0") Integer UserID,
                                              @CookieValue(value = "UserPassword", defaultValue = "") String UserPassword) {
        Operation operation = new Operation();
        Objects objects = new Objects();
        ResultInfo resultInfo = new ResultInfo();
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

    @PostMapping(value = "/studentAssess", produces = "application/json;charset=UTF-8")
    public String BuildNewStudentAssess(@RequestParam(value = "UserID", defaultValue = "0") Integer UserID,
                                        @RequestParam(value = "UserPassword", defaultValue = "") String UserPassword,
                                        @RequestParam(name = "Assess") String assess,
                                        @RequestParam(name = "Score") Integer score,
                                        @RequestParam(name = "Student") String studentInfo) {
        Operation operation = new Operation();
        Objects objects = new Objects();
        ResultInfo resultInfo = new ResultInfo();
        operation.setOperationDescription("POST");
        objects.setObjectName("studentAssess");
        Student student = gson.fromJson(studentInfo, Student.class);
        if (rbacService.CheckPermission(UserID, UserPassword, objects, operation)) {
            resultInfo.setResultInfo(gson.toJson(studentAssessService.BuildNewStudentAssess(student, UserID, assess, score)));
        } else {
            resultInfo.setResultInfo("无权访问！！");
        }
        return gson.toJson(resultInfo);
    }
}

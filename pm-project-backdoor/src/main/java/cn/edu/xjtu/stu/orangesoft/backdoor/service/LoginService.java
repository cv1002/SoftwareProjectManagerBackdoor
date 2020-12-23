package cn.edu.xjtu.stu.orangesoft.backdoor.service;

import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.*;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.RoleMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.StudentMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.TeamMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    RoleMapper rolemapper;
    @Autowired
    UserMapper usermapper;
    @Autowired
    TeamMapper teammapper;
    @Autowired
    StudentMapper studentmapper;

    // TODO 半成品
    public Login login(Integer UserID, String UserPassword) {
        User user = usermapper.GetUserByIDAndPassword(UserID, UserPassword);
        Role role = rolemapper.GetRoleByID(user.getRoleID());
        Student student = studentmapper.GetStudentDataByUserID(user.getUserID());
        Team team = teammapper.GetTeamByTeamID(student.getTeamID());

        Login loginResult = new Login();
        loginResult.setFinish("Finish");
        loginResult.setLoginType("Student");
        loginResult.setTeamID(team.getTeamID());
        loginResult.setTeamName(team.getTeamName());
        loginResult.setRoleName(role.getRoleName());

        return loginResult;
    }
}

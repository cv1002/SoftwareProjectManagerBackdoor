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
        User user = null;
        Role role = null;
        Team team = null;

        user = usermapper.GetUserByIDAndPassword(UserID, UserPassword);
        if (user != null) {
            role = rolemapper.GetRoleByID(user.getRoleID());
            Student student = studentmapper.GetStudentDataByUserID(user.getUserID());
            if (student != null) {
                team = teammapper.GetTeamByTeamID(student.getTeamID());
            }
        }
        Login loginResult = new Login();
        loginResult.setFinish("Finish");
        loginResult.setLoginType("Student");
        if (team != null) {
            loginResult.setTeamID(team.getTeamID());
            loginResult.setTeamName(team.getTeamName());
        }
        if (role != null) {
            loginResult.setRoleName(role.getRoleName());
        }
        return loginResult;
    }
}

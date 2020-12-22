package cn.edu.xjtu.stu.orangesoft.backdoor.bean;

import org.springframework.stereotype.Component;

@Component
public class Role {
    private Integer RoleID;
    private String RoleName;

    public Integer getRoleId() {
        return RoleID;
    }

    public String getRoleName() {
        return RoleName;
    }

//    @Override
//    public String toString() {
//        return "{" +
//                "\"RoleID\" : " + RoleID + "\n" +
//                "\"RoleName=\" : " + RoleName + "\n" +
//                "}";
//    }
}

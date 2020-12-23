package cn.edu.xjtu.stu.orangesoft.backdoor.unusedbeans;

import org.springframework.stereotype.Component;

@Component
public class RolePowerAssignment {
    private int AssignmentID;
    private int RoleID;
    private String ConfigID;

    public int getAssignmentID() {
        return AssignmentID;
    }

    public void setAssignmentID(int assignmentID) {
        AssignmentID = assignmentID;
    }

    public int getRoleID() {
        return RoleID;
    }

    public void setRoleID(int roleID) {
        RoleID = roleID;
    }

    public String getConfigID() {
        return ConfigID;
    }

    public void setConfigID(String configID) {
        ConfigID = configID;
    }
}

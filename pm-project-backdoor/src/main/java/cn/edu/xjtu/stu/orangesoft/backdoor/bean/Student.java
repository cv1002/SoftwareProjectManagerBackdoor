package cn.edu.xjtu.stu.orangesoft.backdoor.bean;

import org.springframework.stereotype.Component;

@Component
public class Student {
    private int StudentUserID;
    private String StudentClass;
    private int StudentID;
    private int TeamID;

    public int getStudentUserID() {
        return StudentUserID;
    }

    public void setStudentUserID(int studentUserID) {
        StudentUserID = studentUserID;
    }

    public String getStudentClass() {
        return StudentClass;
    }

    public void setStudentClass(String studentClass) {
        StudentClass = studentClass;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int studentID) {
        StudentID = studentID;
    }

    public int getTeamID() {
        return TeamID;
    }

    public void setTeamID(int teamID) {
        TeamID = teamID;
    }
}

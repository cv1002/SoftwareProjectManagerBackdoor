package cn.edu.xjtu.stu.orangesoft.backdoor.bean;

import org.springframework.stereotype.Component;

@Component
public class StudentAssess {
    private int Score;
    private String Assess;
    private int StudentUserID;
    private int AssessorID;

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public String getAssess() {
        return Assess;
    }

    public void setAssess(String assess) {
        Assess = assess;
    }

    public int getStudentUserID() {
        return StudentUserID;
    }

    public void setStudentUserID(int studentUserID) {
        StudentUserID = studentUserID;
    }

    public int getAssessorID() {
        return AssessorID;
    }

    public void setAssessorID(int assessorID) {
        AssessorID = assessorID;
    }
}

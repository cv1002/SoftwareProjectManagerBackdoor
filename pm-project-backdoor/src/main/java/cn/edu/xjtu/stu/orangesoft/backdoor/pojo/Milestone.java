package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import org.springframework.stereotype.Component;

@Component
public class Milestone {
    private int MilestoneID;
    private String MilestoneName;
    private String MilestoneDescription;

    public int getMilestoneID() {
        return MilestoneID;
    }

    public void setMilestoneID(int milestoneID) {
        MilestoneID = milestoneID;
    }

    public String getMilestoneName() {
        return MilestoneName;
    }

    public void setMilestoneName(String milestoneName) {
        MilestoneName = milestoneName;
    }

    public String getMilestoneDescription() {
        return MilestoneDescription;
    }

    public void setMilestoneDescription(String milestoneDescription) {
        MilestoneDescription = milestoneDescription;
    }
}

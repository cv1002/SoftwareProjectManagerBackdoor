package cn.edu.xjtu.stu.orangesoft.backdoor.unusedbeans;

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

    public void setMilestoneName(String milestoneName) {
        MilestoneName = milestoneName;
    }

    public void setMilestoneDescription(String milestoneDescription) {
        MilestoneDescription = milestoneDescription;
    }

    public String getMilestoneName() {
        return MilestoneName;
    }

    public String getMilestoneDescription() {
        return MilestoneDescription;
    }
}

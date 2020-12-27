package cn.edu.xjtu.stu.orangesoft.backdoor.service;

import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.GroupAssessMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.UserMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.GroupAssess;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.ResultInfo;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupAssessService {
    @Autowired
    GroupAssessMapper groupAssessMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    RBACService rbacService;
    @Autowired
    ResultInfo resultInfo;
    @Autowired
    GroupAssess groupAssess;

    public GroupAssess FindGroupScoreBySTeamID(Integer TeamID) {
        return groupAssessMapper.GetGroupScoreBySTeamID(TeamID);
    }

    public ResultInfo BuildNewGroupAssess(Team team, Integer UserID, String Assess, Integer Score) {
        groupAssess.setTeamID(team.getTeamID());
        groupAssess.setAssessorID(UserID);
        groupAssess.setTeamAssess(Assess);
        groupAssess.setScore(Score);
        groupAssessMapper.BuildNewGroupAssess(groupAssess);
        if (groupAssess.getTeamID() != 0) {
            resultInfo.setResultInfo("成功！！");
        }
        return resultInfo;
    }
}

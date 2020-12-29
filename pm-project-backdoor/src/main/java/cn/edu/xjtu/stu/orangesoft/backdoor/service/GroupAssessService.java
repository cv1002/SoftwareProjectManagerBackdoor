package cn.edu.xjtu.stu.orangesoft.backdoor.service;

import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.GroupAssessMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.UserMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.GroupAssess;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.ResultInfo;
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

    public GroupAssess FindGroupScoreByTeamID(Integer TeamID) {
        return groupAssessMapper.GetGroupScoreByTeamID(TeamID);
    }

    public ResultInfo BuildNewGroupAssess(Integer TeamID, Integer UserID, String Assess, Integer Score) {
        groupAssess.setTeamID(TeamID);
        groupAssess.setAssessorID(UserID);
        groupAssess.setTeamAssess(Assess);
        groupAssess.setScore(Score);
        if (groupAssessMapper.BuildNewGroupAssess(groupAssess) != 0) {
            resultInfo.setResultInfo("成功！！");
        }
        return resultInfo;
    }
}

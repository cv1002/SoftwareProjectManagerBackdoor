package cn.edu.xjtu.stu.orangesoft.backdoor.service;

import cn.edu.xjtu.stu.orangesoft.backdoor.core.DIUtil;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.TeamMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.TeamMemberCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    @Autowired
    TeamMapper teamMapper;

    public TeamMemberCount GetTeamMemberCount(Integer UserID) {
        TeamMemberCount teamMemberCount = DIUtil.getBean(TeamMemberCount.class);
        teamMemberCount.setCount(teamMapper.GetTeamMembers(UserID).size());
        return teamMemberCount;
    }
}

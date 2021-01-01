package cn.edu.xjtu.stu.orangesoft.backdoor.service;

import cn.edu.xjtu.stu.orangesoft.backdoor.core.DIUtil;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.TeamMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Student;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Team;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.TeamMemberCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class TeamService {
    @Autowired
    TeamMapper teamMapper;

    public TeamMemberCount GetTeamMemberCount(Integer UserID) {
        TeamMemberCount teamMemberCount = DIUtil.getBean(TeamMemberCount.class);
        teamMemberCount.setCount(teamMapper.GetTeamMembers(UserID).size());
        return teamMemberCount;
    }

    /**
     * 根据小组id查询小组成员列表
     *
     * @param TeamID 要查找的小组id
     * @return 小组成员列表
     */
    public List<Student> GetTeamMembers(Integer TeamID) {
        return teamMapper.GetTeamMembersByTeamID(TeamID);
    }

    /**
     * 查询所有小组以及各小组下的成员
     *
     * @return 所有Team与其下成员的map对象
     */
    public HashMap<Team, List<Student>> GetAllTeamMembers() {
        HashMap<Team, List<Student>> allTeamMembers = new HashMap<>();
        for (Team i : teamMapper.GetAllTeams()) {
            allTeamMembers.put(i, teamMapper.GetTeamMembersByTeamID(i.getTeamID()));
        }
        return allTeamMembers;
    }
}

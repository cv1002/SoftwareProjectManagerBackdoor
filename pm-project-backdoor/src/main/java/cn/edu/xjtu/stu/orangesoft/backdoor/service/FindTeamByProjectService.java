package cn.edu.xjtu.stu.orangesoft.backdoor.service;

import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.ProjectAssignmentMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.UserMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.*;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FindTeamByProjectService {
    @Autowired
    ProjectAssignmentMapper projectAssignmentMapper;
    @Autowired
    ProjectAssignmentResult projectAssignmentResult;
    @Autowired
    UserMapper userMapper;
    @Autowired
    RBACService rbacService;

    /**
     * 根据projetID查找所有选择该项目的小组信息
     * @param UserID 查询发起人id，来自cookie
     * @param UserPassword 查询发起人密码，来自cookie
     * @param operation 操作，即接口类型
     * @param object 对象，即接口
     * @param projectID 目标项目
     * @return null或者ProjectAssignmentResult列表
     */
    public List<ProjectAssignmentResult> FindTeamByProject(Integer UserID,
                                                           String UserPassword, Operation operation,
                                                           Object object,int projectID){
        User user = userMapper.GetUserByIDAndPassword(UserID,UserPassword);
        if(user != null){
            if(rbacService.CheckPermission(user.getRoleID(),object,operation)){
                List<ProjectAssignment> origin = projectAssignmentMapper.getProjectAssignmentByProjectID(projectID);
                List<ProjectAssignmentResult> results =new ArrayList<>();
                origin.forEach((e)->{
                    projectAssignmentResult.setTeamID(e.getTeamID());
                    projectAssignmentResult.setProjectStartTime(e.getProjectStartTime());
                    projectAssignmentResult.setProjectDeadline(e.getProjectDeadline());
                    results.add(projectAssignmentResult);
                });
                return results;
            }
        }
        return null;
    }
}

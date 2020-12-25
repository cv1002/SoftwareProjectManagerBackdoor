/*
 * @Author: your name
 * @Date: 2020-12-25 16:42:45
 * @LastEditTime: 2020-12-25 16:44:01
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \undefinedc:\Users\10259\Desktop\软件项目管理项目\后端项目\SoftwareProjectManagerBackdoor\pm-project-backdoor\src\main\java\cn\edu\xjtu\stu\orangesoft\backdoor\service\ProjectService.java
 */
package cn.edu.xjtu.stu.orangesoft.backdoor.service;

import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.ProjectAssignmentMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.ProjectMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.UserMapper;
<<<<<<< HEAD
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.*;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Object;
=======
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Object;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.*;
>>>>>>> main
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {
    @Autowired
    ProjectAssignmentMapper projectAssignmentMapper;
    @Autowired
    ProjectAssignmentResult projectAssignmentResult;
    @Autowired
    UserMapper userMapper;
    @Autowired
    RBACService rbacService;
    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    Projects projects;

    /**
     * 根据projetID查找所有选择该项目的小组信息
     *
     * @param UserID       查询发起人id，来自cookie
     * @param UserPassword 查询发起人密码，来自cookie
     * @param operation    操作，即接口类型
     * @param object       对象，即接口
     * @param projectID    目标项目
     * @return null或者ProjectAssignmentResult列表
     */
    public List<ProjectAssignmentResult> FindTeamByProject(Integer UserID,
                                                           String UserPassword, Operation operation,
                                                           Object object, int projectID) {
        User user = userMapper.GetUserByIDAndPassword(UserID, UserPassword);
        if (user != null) {
            if (rbacService.CheckPermission(user.getRoleID(), object, operation)) {
                List<ProjectAssignment> origin = projectAssignmentMapper.getProjectAssignmentByProjectID(projectID);
                List<ProjectAssignmentResult> results = new ArrayList<>();
                origin.forEach((e) -> {
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

    /**
     * 根据projetID查找所有选择该项目的小组信息
     *
     * @param UserID       查询发起人id，来自cookie
     * @param UserPassword 查询发起人密码，来自cookie
     * @param operation    操作，即接口类型
     * @param object       对象，即接口
     * @param projectID    目标项目
     * @return null或者ProjectAssignmentResult列表
     */
    public List<ProjectAssignmentResult> FindTeamByProject(Integer UserID,
                                                           String UserPassword, Operation operation,
                                                           Object object, int projectID) {
        User user = userMapper.GetUserByIDAndPassword(UserID, UserPassword);
        if (user != null) {
            if (rbacService.CheckPermission(user.getRoleID(), object, operation)) {
                List<ProjectAssignment> origin = projectAssignmentMapper.getProjectAssignmentByProjectID(projectID);
                List<ProjectAssignmentResult> results = new ArrayList<>();
                origin.forEach((e) -> {
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

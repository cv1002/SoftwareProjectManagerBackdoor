package cn.edu.xjtu.stu.orangesoft.backdoor.service;

import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.ProjectAssignmentMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.ProjectMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.UserMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Project;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.ProjectAssignment;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    ProjectAssignmentMapper projectAssignmentMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    RBACService rbacService;
    @Autowired
    ProjectMapper projectMapper;
//    @Autowired
//    ResultInfo resultInfo;
//    @Autowired
//    Project project;

    /**
     * 查询所有项目，只有老师有权限
     *
     * @return project列表
     */
    public List<Project> FindAllProjects() {
        return projectMapper.GetAllProjects();
    }

    /**
     * 根据projectID查找所有选择该项目的小组信息
     *
     * @param projectID 目标项目
     * @return ProjectAssignmentResult列表
     */
    public List<ProjectAssignment> FindTeamByProject(int projectID) {
        return projectAssignmentMapper.getProjectAssignmentByProjectID(projectID);
    }

    /**
     * 根据UserID查找所属项目
     *
     * @return 项目对象
     */
    public Project FindProjectByUser(Integer UserID) {
        return projectMapper.GetProjectByUser(UserID);
    }

    /**
     * 新建项目
     *
     * @param ProjectName 新建项目名
     * @param Description 项目描述
     * @return ResultInfo
     */
    public ResultInfo BulidNewProject(String ProjectName, String Description) {
        ResultInfo resultInfo = new ResultInfo();
        Project project = new Project();
        project.setProjectID(0);
        project.setProjectName(ProjectName);
        project.setProjectDescription(Description);
        projectMapper.BuildNewProject(project);
        if (project.getProjectID() != 0) {
            resultInfo.setResultInfo("成功！！");
        }
        return resultInfo;
    }
}

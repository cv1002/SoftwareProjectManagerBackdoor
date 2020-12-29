package cn.edu.xjtu.stu.orangesoft.backdoor.service;

import cn.edu.xjtu.stu.orangesoft.backdoor.core.DIUtil;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.ProjectAssignmentMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.ProjectMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.UserMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Project;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.ProjectAssignment;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
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
    public ResultInfo BuildNewProject(String ProjectName, String Description) {
        ResultInfo resultInfo = DIUtil.getBean(ResultInfo.class);
        Project project = DIUtil.getBean(Project.class);
        project.setProjectID(0);
        project.setProjectName(ProjectName);
        project.setProjectDescription(Description);
        if (projectMapper.BuildNewProject(project) != 0) {
            resultInfo.setResultInfo("成功！！");
        }
        return resultInfo;
    }

    /**
     * 新建项目指派
     *
     * @param ProjectID 项目ID
     * @param TeamID    项目指派给某个小组
     * @return ResultInfo 完成情况
     */
    public ResultInfo BuildNewProjectAssignment(int ProjectID, int TeamID, String DeadLine) {
        ResultInfo resultInfo = DIUtil.getBean(ResultInfo.class);
        Project project = DIUtil.getBean(Project.class);
        ProjectAssignment projectAssignment = DIUtil.getBean(ProjectAssignment.class);

        projectAssignment.setProjectID(ProjectID);
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        projectAssignment.setProjectStartTime(dateFormat.format(date));
        projectAssignment.setProjectDeadline(DeadLine);
        if (projectAssignmentMapper.addProjectAssignment(projectAssignment) != 0) {
            resultInfo.setResultInfo("成功！！");
        } else {
            resultInfo.setResultInfo("失败！！");
        }
        return resultInfo;
    }
}

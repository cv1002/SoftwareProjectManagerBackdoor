package cn.edu.xjtu.stu.orangesoft.backdoor.service;

import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.ProjectMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.UserMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.*;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FindAllProjectsService {
    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    RBACService rbacService;
    @Autowired
    UserMapper userMapper;
    @Autowired
    Projects projects;

    /**
     * 查询所有项目，只有老师有权限
     * @param UserID  查询发起人id，来自cookie
     * @param UserPassword  查询发起人密码，来自cookie
     * @param operation  操作，即接口类型
     * @param object  对象，即接口
     * @return  null 或者 projects列表
     */
    public List<Projects> FindAllProjects(Integer UserID,
                                          String UserPassword, Operation operation, Object object){
        User user = userMapper.GetUserByIDAndPassword(UserID,UserPassword);
        if(user != null){
            if(rbacService.CheckPermission(user.getRoleID(),object,operation)){
                List<Project> allProject = projectMapper.GetAllProjects();//查询到的对象列表
                List<Projects> allProjects = new ArrayList<>();//要返回的对象列表
                allProject.forEach((e) ->{
                    projects.setProjectID(e.getProjectID());
                    projects.setProjectDescription(e.getProjectDescription());
                    allProjects.add(projects);
                });
                return allProjects;
            }
        }
        return null;
    }
}

package cn.edu.xjtu.stu.orangesoft.backdoor.service;

import cn.edu.xjtu.stu.orangesoft.backdoor.core.DIUtil;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.CommunicationMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.StudentMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Communication;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunicationService {
    @Autowired
    CommunicationMapper communicationMapper;

    @Autowired
    StudentMapper studentmapper;

    public List<Communication> GetAllCommunication() {
        return communicationMapper.GetAllCommunication();
    }

    public List<Communication> GetCommunication(Integer TeamID) {
        return communicationMapper.GetCommunication(TeamID);
    }

    public ResultInfo PostCommunication(Integer userID, Integer teamID, String context, Integer fileID) {
        ResultInfo resultInfo = DIUtil.getBean(ResultInfo.class);
        Communication communication = DIUtil.getBean(Communication.class);
        communication.setCommunicationID(0);
        communication.setUserID(userID);
        communication.setTeamID(teamID);
        communication.setContext(context);
        if (fileID != null) {
            communication.setFileID(fileID);
        }
        if (communicationMapper.PostCommunication(communication) != 0) {
            resultInfo.setResultInfo("成功！！");
        } else {
            resultInfo.setResultInfo("失败！！");
        }
        return resultInfo;
    }
}

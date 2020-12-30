package cn.edu.xjtu.stu.orangesoft.backdoor.service;

import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.FileAssessMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.UserMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.FileAssess;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.FileInfo;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class FileAssessService {
    @Autowired
    FileAssessMapper fileAssessMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    RBACService rbacService;
    @Autowired
    ResultInfo resultInfo;
    @Autowired
    FileAssess fileAssess;

    public FileAssess FindFileAssessByFileID(Integer FileID) {
        return fileAssessMapper.GetFileAssessByFileID(FileID);
    }

    public ResultInfo BuildNewFileAssess(FileInfo fileInfo, Integer UserID, String Assess) {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String assessTime = sdf.format(d);
        fileAssess.setAssessTime(assessTime);
        fileAssess.setFileID(fileInfo.getFileID());
        fileAssess.setAssessorID(UserID);
        fileAssess.setFileAssess(Assess);
        if (fileAssessMapper.BuildNewFileAssess(fileAssess) != 0) {
            resultInfo.setResultInfo("成功！！");
        }
        return resultInfo;
    }
}

package cn.edu.xjtu.stu.orangesoft.backdoor.controller;

<<<<<<< HEAD
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.*;
import cn.edu.xjtu.stu.orangesoft.backdoor.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
=======
import org.springframework.web.bind.annotation.RestController;
>>>>>>> main

@RestController
public class FileController {
    @Autowired
    FileService fileService;
    //TODO
    @GetMapping(value = "/file/{fileID}", produces = "application/json;charset=UTF-8")
    public Files getFile(@PathVariable("fileID") Integer FileID
                          /*@CookieValue("userid") Integer UserID,
                          @CookieValue("password") String UserPassword*/) {
        return fileService.getFilesByID(FileID);
    }
    @GetMapping(value = "/file", produces = "application/json;charset=UTF-8")
    public List<Files> getFiles(@RequestParam("TeamID") Integer TeamID) {
        return fileService.getFileByTeamID(TeamID);
    }


}

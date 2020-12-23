package cn.edu.xjtu.stu.orangesoft.backdoor.controller;

import org.springframework.web.bind.annotation.*;

@RestController(value = "/error")
public class ErrorController {
    @GetMapping(value = "/error", produces = "application/json;charset=UTF-8")
    public String ErrorForGet() {
        return "ERROR: your request failed...";
    }
    @PostMapping(value = "/error", produces = "application/json;charset=UTF-8")
    public String ErrorForPost() {
        return "ERROR: your request failed...";
    }
    @DeleteMapping(value = "/error", produces = "application/json;charset=UTF-8")
    public String ErrorForDelete() {
        return "ERROR: your request failed...";
    }
    @PutMapping(value = "/error", produces = "application/json;charset=UTF-8")
    public String ErrorForPut() {
        return "ERROR: your request failed...";
    }
}

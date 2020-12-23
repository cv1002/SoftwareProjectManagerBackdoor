package cn.edu.xjtu.stu.orangesoft.backdoor.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "cn.edu.xjtu.stu.orangesoft.backdoor.mapper")
@SpringBootApplication(scanBasePackages = {"cn.edu.xjtu.stu.orangesoft.backdoor"})
public class PmProjectBackdoorApplication {
    public static void main(String[] args) {
        SpringApplication.run(PmProjectBackdoorApplication.class, args);
    }
}

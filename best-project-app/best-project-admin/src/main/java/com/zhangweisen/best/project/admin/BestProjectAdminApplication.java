package com.zhangweisen.best.project.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.zhangweisen.best.project.admin", "com.zhangweisen.best.project.common"})
public class BestProjectAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(BestProjectAdminApplication.class, args);
    }

}

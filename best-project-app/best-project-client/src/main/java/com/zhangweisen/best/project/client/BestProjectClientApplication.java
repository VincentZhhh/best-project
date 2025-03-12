package com.zhangweisen.best.project.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.zhangweisen.best.project.client", "com.zhangweisen.best.project.common"})
public class BestProjectClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(BestProjectClientApplication.class, args);
    }

}

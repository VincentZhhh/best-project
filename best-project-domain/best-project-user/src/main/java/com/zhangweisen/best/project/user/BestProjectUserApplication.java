package com.zhangweisen.best.project.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.time.Instant;

@SpringBootApplication
@MapperScan(basePackages = {"com.zhangweisen.best.project.user.mapper"})
@ComponentScan(basePackages = {"com.zhangweisen.best.project.user", "com.zhangweisen.best.project.common"})
public class BestProjectUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(BestProjectUserApplication.class, args);
    }

}

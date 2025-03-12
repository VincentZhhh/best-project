package com.zhangweisen.best.project.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.zhangweisen.best.project.order.mapper"})
@ComponentScan(basePackages = {"com.zhangweisen.best.project.order", "com.zhangweisen.best.project.common"})
public class BestProjectOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BestProjectOrderApplication.class, args);
    }

}

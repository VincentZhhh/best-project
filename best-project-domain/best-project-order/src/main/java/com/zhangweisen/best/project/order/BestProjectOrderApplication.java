package com.zhangweisen.best.project.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.zhangweisen.best.project.order.mapper"})
public class BestProjectOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BestProjectOrderApplication.class, args);
    }

}

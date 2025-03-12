package com.zhangweisen.best.project.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.zhangweisen.best.project.product.mapper"})
@ComponentScan(basePackages = {"com.zhangweisen.best.project.product", "com.zhangweisen.best.project.common"})
public class BestProjectProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(BestProjectProductApplication.class, args);
    }

}

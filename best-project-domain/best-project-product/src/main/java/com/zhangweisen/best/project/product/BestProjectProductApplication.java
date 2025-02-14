package com.zhangweisen.best.project.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.zhangweisen.best.project.product.mapper"})
public class BestProjectProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(BestProjectProductApplication.class, args);
    }

}

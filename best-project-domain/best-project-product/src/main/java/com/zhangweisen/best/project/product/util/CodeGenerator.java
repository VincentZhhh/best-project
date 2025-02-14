package com.zhangweisen.best.project.product.util;

import java.util.Arrays;
import java.util.List;

import static com.zhangweisen.best.project.mybatis.util.CodeGenerator.generate;

public class CodeGenerator {

    public static void main(String[] args) {
        // 数据源配置
        String url = "jdbc:mysql://localhost:3306/bp_product?useSSL=false&autoReconnect=true&characterEncoding=utf8&serverTimezone=UTC";
        String username = "root";
        String password = "zws812000";
        String outputDir = "/Users/apple/Desktop/work/best-project/best-project-domain/best-project-product/src/main/java";
        List<String> tableNames = Arrays.asList("product");

        generate(url, username, password, outputDir, "com.zhangweisen.best.project.product", tableNames);
    }
}

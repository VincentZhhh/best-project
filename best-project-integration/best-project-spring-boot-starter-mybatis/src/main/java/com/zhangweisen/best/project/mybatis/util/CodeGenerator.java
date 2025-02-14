package com.zhangweisen.best.project.mybatis.util;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.zhangweisen.best.project.mybatis.base.BaseEntity;
import com.zhangweisen.best.project.mybatis.handler.MySqlTypeConvertHandler;

import java.util.List;

public class CodeGenerator {

    public static void generate(String url, String username, String password, String outputDir, String packageName, List<String> tableNames) {
        // 数据源配置
        DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig
                .Builder(url, username, password)
                .typeConvertHandler(new MySqlTypeConvertHandler());

        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                // 全局配置
                .globalConfig(builder -> {
                    builder.author("zhangweisen") // 设置作者
                            .disableOpenDir()
                            .outputDir(outputDir); // 指定输出目录
                })
                // 包配置
                .packageConfig(builder -> {
                    builder.parent(packageName); // 设置父包名
                })
                // 策略配置
                .strategyConfig(builder -> {
                    builder.addInclude(tableNames) // 设置需要生成的表名
                            // 实体配置
                            .entityBuilder()
                            .disableSerialVersionUID()
                            .addIgnoreColumns("id", "create_at", "update_at", "delete_at")
                            .superClass(BaseEntity.class) // 父类基本类
                            .enableLombok()// 开启 lombok 模型
                            // Controller配置
                            .controllerBuilder()
                            .enableRestStyle()// 开启生成@RestController 控制器
                            // Service配置
                            .serviceBuilder()
                            .superServiceClass(IService.class)
                            .superServiceImplClass(ServiceImpl.class)
                            // Mapper配置
                            .mapperBuilder()
                            .superClass(BaseMapper.class)
                            ;
                })
                // 模板引擎配置
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}

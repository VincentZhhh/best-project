package com.zhangweisen.best.project.mybatis.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.zhangweisen.best.project.mybatis.handler.CustomTenantHandler;
import com.zhangweisen.best.project.mybatis.handler.MyMetaObjectHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.TimeZone;

@AutoConfiguration
public class MybatisAutoConfiguration {

    @Value("${mybatis-tenant.enable:false}")
    private Boolean mybatisTenantEnable;

    @Bean
    public MyMetaObjectHandler myMetaObjectHandler() {
        return new MyMetaObjectHandler();
    }

    /**
     * 添加分页插件
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();

        // 多租户插件
        if (mybatisTenantEnable) {
            TenantLineInnerInterceptor tenantInterceptor = new TenantLineInnerInterceptor();
            tenantInterceptor.setTenantLineHandler(new CustomTenantHandler());
            interceptor.addInnerInterceptor(tenantInterceptor);
        }

        // 分页插件
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL)); // 如果配置多个插件, 切记分页最后添加
        return interceptor;
    }

}

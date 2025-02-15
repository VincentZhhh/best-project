package com.zhangweisen.best.project.mybatis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.zhangweisen.best.project.mybatis.holder.TenantContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;

@Configuration
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createAt", Instant.class, Instant.now());
        this.strictUpdateFill(metaObject, "updateAt", Instant.class, Instant.now());
        // 租户id自动插入
        String tenantId = TenantContextHolder.getTenantId();
        if (tenantId != null) {
            this.strictInsertFill(metaObject, "tenantId", String.class, tenantId);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateAt", Instant.class, Instant.now());
    }

}

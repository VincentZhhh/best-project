package com.zhangweisen.best.project.mybatis.handler;

import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.zhangweisen.best.project.mybatis.holder.TenantContextHolder;
import net.sf.jsqlparser.expression.StringValue;
import net.sf.jsqlparser.expression.Expression;

import java.util.Objects;

public class CustomTenantHandler implements TenantLineHandler {

    @Override
    public Expression getTenantId() {
        String tenantId = TenantContextHolder.getTenantId();
        return new StringValue(tenantId);
    }

    @Override
    public String getTenantIdColumn() {
        return "tenant_id";
    }

    @Override
    public boolean ignoreTable(String tableName) {
        // 根据需要返回是否忽略该表
        if (Objects.nonNull(TenantContextHolder.getIgnoreTables())) return TenantContextHolder.getIgnoreTables().contains(tableName);
        return false;
    }

}

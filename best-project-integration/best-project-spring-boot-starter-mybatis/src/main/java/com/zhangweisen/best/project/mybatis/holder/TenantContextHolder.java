package com.zhangweisen.best.project.mybatis.holder;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class TenantContextHolder {

    private static final ThreadLocal<String> CONTEXT = new ThreadLocal<>();

    private static final ThreadLocal<List<String>> IGNORE_TABLES = new ThreadLocal<>();

    /**
     * 设置当前线程租户 ID
     */
    public static void setTenantId(String tenantId) {
        log.debug("Setting Tenant ID: {}", tenantId);
        CONTEXT.set(tenantId);
    }

    /**
     * 获取当前线程租户 ID
     */
    public static String getTenantId() {
        return CONTEXT.get();
    }

    /**
     * 设置当前线程忽略表
     */
    public static void setIgnoreTables(List<String> ignoreTables) {
        log.debug("Setting ignoreTables: {}", ignoreTables);
        IGNORE_TABLES.set(ignoreTables);
    }

    /**
     * 获取当前线程忽略表
     */
    public static List<String> getIgnoreTables() {
        return IGNORE_TABLES.get();
    }

    /**
     * 清除当前线程租户 ID，防止内存泄漏
     */
    public static void clear() {
        CONTEXT.remove();
        IGNORE_TABLES.remove();
    }
}


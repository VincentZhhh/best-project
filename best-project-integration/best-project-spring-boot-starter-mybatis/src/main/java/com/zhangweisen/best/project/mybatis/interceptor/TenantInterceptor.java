package com.zhangweisen.best.project.mybatis.interceptor;

import com.zhangweisen.best.project.mybatis.holder.TenantContextHolder;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class TenantInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // 请求结束后清理租户信息，防止内存泄漏
        TenantContextHolder.clear();
    }
}


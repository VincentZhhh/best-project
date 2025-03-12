package com.zhangweisen.best.project.common.handler;

import cn.hutool.json.JSONUtil;
import com.zhangweisen.best.project.common.enumeration.NoWrapper;
import com.zhangweisen.best.project.common.res.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Arrays;

@RestControllerAdvice
public class GlobalResponseHandler implements ResponseBodyAdvice<Object> {
    // 定义需要排除的包
    private static final String[] EXCLUDE_PACKAGES = {
            "org.springdoc",  // Knife4j 的包
    };


    /**
     * 判断是否需要包装响应体
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        // 检查方法是否有 @NoWrapper 注解
        boolean hasMethodAnnotation = returnType.hasMethodAnnotation(NoWrapper.class);

        // 检查类是否有 @NoWrapper 注解
        boolean hasClassAnnotation = returnType.getContainingClass().isAnnotationPresent(NoWrapper.class);

        // 检查是否在排除包中
        boolean isExcludedPackage = Arrays.stream(EXCLUDE_PACKAGES)
                .anyMatch(exp -> returnType.getContainingClass().getPackageName().contains(exp));

        // 若满足以下任一条件，则跳过包装：
        // 1. 方法或类上有 @NoWrapper 注解
        // 2. 类位于排除包中
        return !(hasMethodAnnotation || hasClassAnnotation || isExcludedPackage);
    }

    /**
     * 包装响应体
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        // 处理 String 类型返回值（避免类型转换冲突）
        if (body instanceof String) {
            return JSONUtil.toJsonStr(Result.success(body));
        }
        if (body instanceof Result) {
            return body;
        }
        return Result.success(body);
    }
}

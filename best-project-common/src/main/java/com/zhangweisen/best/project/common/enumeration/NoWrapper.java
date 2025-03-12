package com.zhangweisen.best.project.common.enumeration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标记不需要全局统一响应包装的接口、控制器
 */
@Target({ElementType.METHOD, ElementType.TYPE}) // 支持类和方法
@Retention(RetentionPolicy.RUNTIME)
public @interface NoWrapper {
}

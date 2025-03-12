package com.zhangweisen.best.project.common.res;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {
    SUCCESS(200, "操作成功"),
    PARAM_ERROR(400, "参数错误"),
    UNAUTHORIZED(401, "未授权"),
    FORBIDDEN(403, "禁止访问"),
    INTERNAL_ERROR(500, "系统异常");

    private final Integer code;
    private final String message;

}

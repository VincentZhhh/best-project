package com.zhangweisen.best.project.common.handler;

import com.zhangweisen.best.project.common.exception.BusinessException;
import com.zhangweisen.best.project.common.res.Result;
import com.zhangweisen.best.project.common.res.ResultCode;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 处理业务异常
    @ExceptionHandler(BusinessException.class)
    public Result<Void> handleBusinessException(BusinessException e) {
        return Result.error(e.getCode(), e.getMessage());
    }

    // 处理参数校验异常（如 @Valid 触发）
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<Void> handleValidationException(MethodArgumentNotValidException ex) {
        String errorMsg = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining("; "));
        return Result.error(ResultCode.PARAM_ERROR.getCode(), errorMsg);
    }

    // 兜底处理其他异常
    @ExceptionHandler(Exception.class)
    public Result<Void> handleException(Exception e) {
        return Result.error(ResultCode.INTERNAL_ERROR.getCode(), "系统繁忙，请稍后重试");
    }
}

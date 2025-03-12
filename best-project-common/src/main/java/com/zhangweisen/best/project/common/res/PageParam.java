package com.zhangweisen.best.project.common.res;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

/**
 * 分页参数基类（支持继承扩展）
 */
@Data
public class PageParam {
    @Min(value = 1, message = "页码不能小于1")
    private int pageNum = 1;   // 默认第1页

    @Min(value = 1, message = "每页数量不能小于1")
    @Max(value = 100, message = "每页数量不能超过100")
    private int pageSize = 10; // 默认每页10条
}
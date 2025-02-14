package com.zhangweisen.best.project.mybatis.base;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class BaseEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField(fill = FieldFill.INSERT)
    private Instant createAt;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Instant updateAt;
    @TableLogic
    private Instant deleteAt;
}

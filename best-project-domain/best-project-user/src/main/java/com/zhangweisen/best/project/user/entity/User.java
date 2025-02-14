package com.zhangweisen.best.project.user.entity;

import com.zhangweisen.best.project.mybatis.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author zhangweisen
 * @since 2025-02-11
 */
@Getter
@Setter
public class User extends BaseEntity {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 联系方式
     */
    private String mobile;

    /**
     * 租户标识
     */
    private String tenantId;
}

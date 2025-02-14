package com.zhangweisen.best.project.order.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zhangweisen.best.project.mybatis.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 订单
 * </p>
 *
 * @author zhangweisen
 * @since 2025-02-10
 */
@Getter
@Setter
@TableName("`order`")
public class Order extends BaseEntity {

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 租户标识
     */
    private String tenantId;
}

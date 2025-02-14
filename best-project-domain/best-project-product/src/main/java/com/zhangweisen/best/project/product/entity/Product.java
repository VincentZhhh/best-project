package com.zhangweisen.best.project.product.entity;

import com.zhangweisen.best.project.mybatis.base.BaseEntity;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 产品
 * </p>
 *
 * @author zhangweisen
 * @since 2025-02-13
 */
@Getter
@Setter
public class Product extends BaseEntity {

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品详情
     */
    private String productDetail;

    /**
     * 产品图片
     */
    private String productPic;

    /**
     * 价格(分)
     */
    private Long price;

    /**
     * 上架时间
     */
    private Instant saleTimeBegin;

    /**
     * 下架时间
     */
    private Instant saleTimeEnd;

    /**
     * 租户标识
     */
    private String tenantId;
}

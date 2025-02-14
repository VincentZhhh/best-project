package com.zhangweisen.best.project.order.mapper;

import com.zhangweisen.best.project.order.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;

/**
 * <p>
 * 订单 Mapper 接口
 * </p>
 *
 * @author zhangweisen
 * @since 2025-02-10
 */
public interface OrderMapper extends BaseMapper<Order> {

    // 物理删除
    @Delete("DELETE FROM `order` WHERE id = #{id}")
    boolean deletePhysically(Long id);
}

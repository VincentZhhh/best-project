package com.zhangweisen.best.project.order.service.impl;

import com.zhangweisen.best.project.order.entity.Order;
import com.zhangweisen.best.project.order.mapper.OrderMapper;
import com.zhangweisen.best.project.order.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单 服务实现类
 * </p>
 *
 * @author zhangweisen
 * @since 2025-02-10
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}

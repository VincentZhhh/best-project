package com.zhangweisen.best.project.product.service.impl;

import com.zhangweisen.best.project.product.entity.Product;
import com.zhangweisen.best.project.product.mapper.ProductMapper;
import com.zhangweisen.best.project.product.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品 服务实现类
 * </p>
 *
 * @author zhangweisen
 * @since 2025-02-13
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}

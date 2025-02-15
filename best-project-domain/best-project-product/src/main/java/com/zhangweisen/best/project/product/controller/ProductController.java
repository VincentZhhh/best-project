package com.zhangweisen.best.project.product.controller;

import com.zhangweisen.best.project.mybatis.holder.TenantContextHolder;
import com.zhangweisen.best.project.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 产品 前端控制器
 * </p>
 *
 * @author zhangweisen
 * @since 2025-02-13
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @PostMapping("/list")
    public Object list() {
        TenantContextHolder.setTenantId("1");
        return productService.list();
    }
}

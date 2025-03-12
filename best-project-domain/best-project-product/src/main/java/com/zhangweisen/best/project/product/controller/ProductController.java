package com.zhangweisen.best.project.product.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhangweisen.best.project.common.enumeration.NoWrapper;
import com.zhangweisen.best.project.common.exception.BusinessException;
import com.zhangweisen.best.project.common.res.ResultCode;
import com.zhangweisen.best.project.product.dto.ProductPageDTO;
import com.zhangweisen.best.project.product.entity.Product;
import com.zhangweisen.best.project.product.service.IProductService;
import com.zhangweisen.best.project.common.res.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/page")
    public PageResult<Product> page(@RequestBody @Validated ProductPageDTO dto) {
        Page<Product> page = productService.page(new Page<>(dto.getPageNum(), dto.getPageSize()), new QueryWrapper<>());
        return PageResult.of(page.getRecords(), page.getCurrent(), page.getSize(), page.getTotal());
    }
}

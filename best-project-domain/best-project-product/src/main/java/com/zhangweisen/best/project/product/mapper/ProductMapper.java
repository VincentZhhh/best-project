package com.zhangweisen.best.project.product.mapper;

import com.zhangweisen.best.project.product.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;

/**
 * <p>
 * 产品 Mapper 接口
 * </p>
 *
 * @author zhangweisen
 * @since 2025-02-13
 */
public interface ProductMapper extends BaseMapper<Product> {

    // 物理删除
    @Delete("DELETE FROM `product` WHERE id = #{id}")
    boolean deletePhysically(Long id);

}

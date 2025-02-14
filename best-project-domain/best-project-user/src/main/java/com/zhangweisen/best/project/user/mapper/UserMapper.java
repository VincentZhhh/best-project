package com.zhangweisen.best.project.user.mapper;

import com.zhangweisen.best.project.user.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author zhangweisen
 * @since 2025-02-11
 */
public interface UserMapper extends BaseMapper<User> {

    // 物理删除
    @Delete("DELETE FROM `user` WHERE id = #{id}")
    boolean deletePhysically(Long id);

}

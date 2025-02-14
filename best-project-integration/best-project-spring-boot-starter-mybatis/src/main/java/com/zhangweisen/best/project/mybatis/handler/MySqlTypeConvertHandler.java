package com.zhangweisen.best.project.mybatis.handler;

import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.type.ITypeConvertHandler;
import com.baomidou.mybatisplus.generator.type.TypeRegistry;

/**
 * 自定义类型转换
 */
public class MySqlTypeConvertHandler implements ITypeConvertHandler {

    @Override
    public IColumnType convert(GlobalConfig globalConfig, TypeRegistry typeRegistry, TableField.MetaInfo metaInfo) {
        IColumnType columnType = typeRegistry.getColumnType(metaInfo);
        if (DbColumnType.LOCAL_DATE_TIME.equals(columnType) || DbColumnType.DATE.equals(columnType)) {
            return DbColumnType.INSTANT;
        }
        return columnType;
    }
}
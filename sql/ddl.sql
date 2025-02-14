-- 用户数据库
create schema bp_user collate utf8mb4_general_ci;

CREATE TABLE `user` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                        `update_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                        `delete_at` datetime DEFAULT NULL COMMENT '删除时间',
                        `user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
                        `mobile` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '联系方式',
                        `tenant_id` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '租户标识',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户';


-- 订单数据库
create schema bp_order collate utf8mb4_general_ci;

CREATE TABLE `order` (
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                         `update_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                         `delete_at` datetime DEFAULT NULL COMMENT '删除时间',
                         `order_no` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单编号',
                         `user_id` bigint NOT NULL COMMENT '用户id',
                         `user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
                         `product_id` bigint NOT NULL COMMENT '产品id',
                         `product_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '产品名称',
                         `tenant_id` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '租户标识',
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='订单';




-- 产品数据库
create schema bp_product collate utf8mb4_general_ci;

CREATE TABLE `product` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                           `update_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                           `delete_at` datetime DEFAULT NULL COMMENT '删除时间',
                           `product_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '产品名称',
                           `product_detail` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '产品详情',
                           `product_pic` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '产品图片',
                           `price` bigint DEFAULT NULL COMMENT '价格(分)',
                           `sale_time_begin` datetime DEFAULT NULL COMMENT '上架时间',
                           `sale_time_end` datetime DEFAULT NULL COMMENT '下架时间',
                           `tenant_id` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '租户标识',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='产品';








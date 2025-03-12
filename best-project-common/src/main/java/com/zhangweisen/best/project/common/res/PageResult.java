package com.zhangweisen.best.project.common.res;

import lombok.Data;
import java.util.List;

/**
 * 分页结果统一响应体
 */
@Data
public class PageResult<T> {
    private List<T> list;    // 当前页数据列表
    private PageMeta meta;   // 分页元数据

    public PageResult(List<T> list, PageMeta meta) {
        this.list = list;
        this.meta = meta;
    }

    // 快速构建方法（推荐）
    public static <T> PageResult<T> of(List<T> list, long pageNum, long pageSize, long total) {
        return new PageResult<>(list, new PageMeta(pageNum, pageSize, total));
    }

    /**
     * 分页元数据（不包含具体数据）
     */
    @Data
    public static class PageMeta {
        private long pageNum;     // 当前页码
        private long pageSize;    // 每页数量
        private long total;      // 总记录数
        private long totalPages;  // 总页数

        public PageMeta(long pageNum, long pageSize, long total) {
            this.pageNum = pageNum;
            this.pageSize = pageSize;
            this.total = total;
            this.totalPages = (long) Math.ceil((double) total / pageSize);
        }
    }
}

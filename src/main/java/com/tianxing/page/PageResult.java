package com.tianxing.page;

import lombok.Data;

import java.util.List;

/**
 * <p> 分页返回结果 </p>
 *
 * @program: tianxing
 * @author: 许仕昊
 * @create: 2020-08-06 01:57
 **/
@Data
public class PageResult {
    /**
     * 当前页码
     */
    private int pageNum;
    /**
     * 每页数量
     */
    private int pageSize;
    /**
     * 记录总数
     */
    private long totalSize;
    /**
     * 页码总数
     */
    private int totalPages;
    /**
     * 数据模型
     */
    private List<?> content;
}

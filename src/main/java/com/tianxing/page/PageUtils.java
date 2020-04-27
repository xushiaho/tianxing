package com.tianxing.page;

import com.github.pagehelper.PageInfo;

/**
 * <p> 将分页信息封装到统一的接口 </p>
 *
 * @program: tianxing
 * @author: 许仕昊
 * @create: 2020-04-26 21:34
 **/

public class PageUtils {

    public static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo){

        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}

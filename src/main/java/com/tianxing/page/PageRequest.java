package com.tianxing.page;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p> 分页请求 </p>
 *
 * @program: tianxing
 * @author: 许仕昊
 * @create: 2020-08-06 01:56
 **/
@Data
public class PageRequest {
    /**
     * 当前页码
     */
    @ApiModelProperty(value = "当前页码")
    private int pageNum;
    /**
     * 每页数量
     */
    @ApiModelProperty(value = "每页数量")
    private int pageSize;
}

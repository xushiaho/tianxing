package com.tianxing.common.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 分页信息
 * @program: tianxing
 * @author: 许仕昊
 * @create: 2020-02-02 17:03
 **/

@Data
public class PageVo implements Serializable {

    private static final long serialVersionUID = 1434416354916088751L;

    @ApiModelProperty(value = "页号")
    private int pageNumber;

    @ApiModelProperty(value = "页面大小")
    private int pageSize;

    @ApiModelProperty(value = "排序字段")
    private String sort;

    @ApiModelProperty(value = "排序方式 asc/desc")
    private String order;

}

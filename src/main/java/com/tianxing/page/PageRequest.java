package com.tianxing.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p> 分页请求 </p>
 *
 * @program: tianxing
 * @author: 许仕昊
 * @create: 2020-08-06 01:56
 **/
@Data
@ApiModel(value="分页", description="分页")
public class PageRequest implements Serializable {

    private static final long serialVersionUID = -7663472501251984262L;
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

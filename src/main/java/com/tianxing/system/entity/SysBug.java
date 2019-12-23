package com.tianxing.system.entity;

import java.time.LocalDateTime;
import com.tianxing.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * bug表
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SysBug对象", description="bug表")
public class SysBug extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "Bug名")
    private String bugName;

    @ApiModelProperty(value = "发现人")
    private String finder;

    @ApiModelProperty(value = "发现时间")
    private LocalDateTime findTime;

    @ApiModelProperty(value = "处理人")
    private String handler;

    @ApiModelProperty(value = "处理时间")
    private LocalDateTime handleTime;

    @ApiModelProperty(value = "Bug说明")
    private String show;

    @ApiModelProperty(value = "Bug状态(0:已处理 1:未处理)")
    private String state;


}

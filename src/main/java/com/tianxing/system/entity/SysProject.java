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
 * 项目表
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SysProject对象", description="项目表")
public class SysProject extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "项目名")
    private String projectName;

    @ApiModelProperty(value = "发起人")
    private String originator;

    @ApiModelProperty(value = "模块数")
    private Integer modularNum;

    @ApiModelProperty(value = "接口数")
    private Integer apiNum;


}

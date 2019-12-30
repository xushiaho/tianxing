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
 * 接口表
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SysApis对象", description="接口表")
public class SysApis extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "所属模块ID")
    private Long modularId;

    @ApiModelProperty(value = "接口名")
    private String apisName;

    @ApiModelProperty(value = "请求头")
    private String head;

    @ApiModelProperty(value = "参数")
    private String parameter;

    @ApiModelProperty(value = "返回值")
    private String revert;

    @ApiModelProperty(value = "说明")
    private String illustration;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "接口状态")
    private String state;


}

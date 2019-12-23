package com.tianxing.system.entity.VO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @program: tianxing
 * @author: 许仕昊
 * @create: 2019-12-23 16:11
 **/
@Data
@Accessors(chain = true)
@ApiModel(value="SysDept对象节点", description="部门节点")
public class SysDeptZtreeVO implements Serializable {

    private static final long serialVersionUID = 3238058253509006886L;

    @ApiModelProperty(value = "部门id")
    @TableId(value = "dept_id", type = IdType.AUTO)
    private Long deptId;

    @ApiModelProperty(value = "父部门id")
    private Long parentId;

    @ApiModelProperty(value = "部门名称")
    private String deptName;
}

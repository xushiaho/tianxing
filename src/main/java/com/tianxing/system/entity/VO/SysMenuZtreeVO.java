package com.tianxing.system.entity.VO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @program: tianxing
 * @author: 许仕昊
 * @create: 2019-12-23 16:41
 **/
@Data
@Accessors(chain = true)
@ApiModel(value="SysDept对象节点", description="部门节点")
public class SysMenuZtreeVO implements Serializable {

    private static final long serialVersionUID = 918953313144658055L;
    @ApiModelProperty(value = "菜单id")
    private Long menuId;

    @ApiModelProperty(value = "菜单名称")
    private String menuName;

    @ApiModelProperty(value = "父级菜单id")
    private Long parentId;
}

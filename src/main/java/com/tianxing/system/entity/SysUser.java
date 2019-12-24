package com.tianxing.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.util.List;

import com.tianxing.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SysUser对象", description="用户表")
public class SysUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    @ApiModelProperty(value = "部门id")
    private Long deptId;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    private String phone;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "状态(1:启用 2：禁用)")
    private String flag;

    @ApiModelProperty(value = "token")
    private String token;

    @ApiModelProperty(value = "盐值")
    private String salt;

    @ApiModelProperty(value = "部门对象")
    private SysDept dept;

    @ApiModelProperty(value = "角色组")
    private List<SysRole> roles;

    public SysDept getDept() {
        if (dept == null){
            dept = new SysDept();
        }
        return dept;
    }

    public void setDept(SysDept dept) {
        this.dept = dept;
    }

}

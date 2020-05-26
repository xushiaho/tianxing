package com.tianxing.system.mapper;

import com.github.pagehelper.Page;
import com.tianxing.system.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
/**
 * <p>
 * 角色信息表 Mapper 接口
 * </p>
 *
 * @author 许仕昊
 * @since 2020-05-26
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
    * 查询角色信息表列表
    * @param sysRole
    * @return
    */
    Page<SysRole> selectSysRoleList(SysRole sysRole);

     /**
     * 校验角色名是否唯一
     * @param roleName
     * @return
     */
     int checkSysRoleName(String roleName);
 }

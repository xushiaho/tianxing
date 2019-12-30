package com.tianxing.system.mapper;

import com.tianxing.system.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
/**
 * <p>
 * 角色信息表 Mapper 接口
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-30
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
    * 查询角色信息表列表
    * @param page
    * @return
    */
    List<SysRole> selectSysRoleList(Page<SysRole> page);

     /**
     * 校验角色名是否唯一
     * @param roleName
     * @return
     */
     int checkSysRoleName(String roleName);
 }

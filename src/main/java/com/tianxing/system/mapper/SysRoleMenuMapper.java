package com.tianxing.system.mapper;

import com.tianxing.system.entity.SysRoleMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
/**
 * <p>
 * 角色和菜单关联表 Mapper 接口
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-30
 */
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {

    /**
    * 查询角色和菜单关联表列表
    * @param page
    * @return
    */
    List<SysRoleMenu> selectSysRoleMenuList(Page<SysRoleMenu> page);

     /**
     * 校验角色名是否唯一
     * @param roleName
     * @return
     */
     int checkSysRoleMenuName(String roleName);
 }

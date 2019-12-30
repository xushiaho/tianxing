package com.tianxing.system.mapper;

import com.tianxing.system.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
/**
 * <p>
 * 菜单权限表 Mapper 接口
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-30
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
    * 查询菜单权限表列表
    * @param page
    * @return
    */
    List<SysMenu> selectSysMenuList(Page<SysMenu> page);

     /**
     * 校验菜单名是否唯一
     * @param menuName
     * @return
     */
     int checkSysMenuName(String menuName);
 }

package com.tianxing.system.mapper;

import com.github.pagehelper.Page;
import com.tianxing.system.entity.SysDept;
import com.tianxing.system.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
/**
 * <p>
 * 菜单权限表 Mapper 接口
 * </p>
 *
 * @author 许仕昊
 * @since 2020-05-26
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
    * 查询菜单权限表列表
    * @param sysMenu
    * @return
    */
    List<SysMenu> selectSysMenuList(SysMenu sysMenu);


    Page<SysMenu> selectList(SysMenu sysMenu);
     /**
     * 校验菜单名是否唯一
     * @param menuName
     * @return
     */
     int checkSysMenuName(String menuName);

     List<SysMenu> selectPage(SysMenu sysMenu);
 }

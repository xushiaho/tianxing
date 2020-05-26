package com.tianxing.system.service;

import com.github.pagehelper.Page;
import com.tianxing.system.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @author 许仕昊
 * @since 2020-05-26
 */
public interface ISysMenuService extends IService<SysMenu> {

    /**
    * 查询菜单权限表列表
    * @param sysMenu
    * @return
    */
    List<SysMenu> selectSysMenuList(SysMenu sysMenu);

    Page<SysMenu> selectList(SysMenu sysMenu);
    /**
    * 新增菜单
    * @param sysMenu
    * @return
    */
    int saveSysMenu(SysMenu sysMenu);

    /**
    * 修改菜单
    * @param sysMenu
    * @return
    */
    int updateSysMenu(SysMenu sysMenu);

    /**
    * 根据菜单id删除菜单
    * @param menuId
    * @return
    */
    int deleteSysMenu(Long menuId);

    /**
    * 校验菜单名是否唯一
    * @param menuName
    * @return
    */
    String checkSysMenuName(String menuName);
}

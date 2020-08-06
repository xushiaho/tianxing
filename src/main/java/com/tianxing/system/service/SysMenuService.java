package com.tianxing.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tianxing.system.entity.SysMenu;
import com.tianxing.page.PageRequest;
import com.tianxing.page.PageResult;

import java.util.List;

/**
 * 菜单权限表(SysMenu)表服务接口
 *
 * @author 许仕昊
 * @since 2020-08-06 21:52:19
 */
public interface SysMenuService extends IService<SysMenu> {

    /**
    * 查询菜单权限表列表信息
    * @param sysMenu
    * @return
    */
    List<SysMenu> selectSysMenuList(SysMenu sysMenu);

    /**
     * 分页模糊查询菜单权限表列表信息
     * @param pageRequest 分页
     * @param sysMenu 实体类对象
     * @return
     */
    PageResult selectSysMenuListPage(PageRequest pageRequest, SysMenu sysMenu);

    /**
    * 新增菜单权限表信息
    * @param sysMenu
    * @return
    */
    void saveSysMenu(SysMenu sysMenu);

    /**
    * 修改菜单权限表信息
    * @param sysMenu
    * @return
    */
    void updateSysMenu(SysMenu sysMenu);


    /**
     * 根据id批量删除菜单权限表信息
     * @param menuIds
     * @return
     */
    void deleteSysMenus(Long[] menuIds);
    
}
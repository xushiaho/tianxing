package com.tianxing.system.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.github.pagehelper.PageInfo;
import com.tianxing.system.entity.SysDept;
import com.tianxing.system.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @author 许仕昊
 * @since 2020-04-26
 */
public interface ISysMenuService extends IService<SysMenu> {

    List<Map> findAll(Integer menuId);
    /**
    * 查询菜单权限表列表
    * @param page
    * @return
    */
    List<SysMenu> selectSysMenuList(Page<SysMenu> page);

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

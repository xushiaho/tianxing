package com.tianxing.system.service;

import com.tianxing.system.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-30
 */
public interface ISysMenuService extends IService<SysMenu> {

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
    String checkSysMenuName(String menuName);
}

package com.tianxing.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tianxing.system.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.*;

/**
 * <p>
 * 菜单权限表 Mapper 接口
 * </p>
 *
 * @author 许仕昊
 * @since 2020-04-26
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<Map> findAll(Map param);

    List<SysMenu> findAll1(SysMenu sysMenu);

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

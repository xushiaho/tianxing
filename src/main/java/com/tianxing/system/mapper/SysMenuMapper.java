package com.tianxing.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tianxing.system.entity.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单权限表(SysMenu)表数据库访问层
 *
 * @author 许仕昊
 * @since 2020-08-06 21:52:19
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    /**
    * 查询菜单权限表列表
    * @param sysMenu
    * @return
    */
    List<SysMenu> selectSysMenuList(SysMenu sysMenu);
    
}
package com.tianxing.system.service;

import com.tianxing.system.entity.SysRoleMenu;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 角色菜单关联表  服务类
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-23
 */
public interface ISysRoleMenuService extends IService<SysRoleMenu> {

    /**
    * 校验角色名是否唯一
    * @param roleName
    * @return
    */
    String checkSysRoleMenuName(String roleName);
}

package com.tianxing.system.service;

import com.tianxing.system.entity.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户角色关联表  服务类
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-23
 */
public interface ISysUserRoleService extends IService<SysUserRole> {

    /**
    * 校验用户名是否唯一
    * @param userName
    * @return
    */
    String checkSysUserRoleName(String userName);
}

package com.tianxing.system.service;

import com.github.pagehelper.Page;
import com.tianxing.system.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
/**
 * <p>
 * 角色信息表 服务类
 * </p>
 *
 * @author 许仕昊
 * @since 2020-05-26
 */
public interface ISysRoleService extends IService<SysRole> {

    /**
    * 查询角色信息表列表
    * @param sysRole
    * @return
    */
    Page<SysRole> selectSysRoleList(SysRole sysRole);

    /**
    * 新增角色
    * @param sysRole
    * @return
    */
    int saveSysRole(SysRole sysRole);

    /**
    * 修改角色
    * @param sysRole
    * @return
    */
    int updateSysRole(SysRole sysRole);

    /**
    * 根据角色id删除角色
    * @param roleId
    * @return
    */
    int deleteSysRole(Long roleId);

    /**
    * 校验角色名是否唯一
    * @param roleName
    * @return
    */
    String checkSysRoleName(String roleName);
}

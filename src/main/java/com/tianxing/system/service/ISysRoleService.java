package com.tianxing.system.service;

import com.tianxing.system.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
/**
 * <p>
 * 角色信息表 服务类
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-30
 */
public interface ISysRoleService extends IService<SysRole> {

    /**
    * 查询角色信息表列表
    * @param page
    * @return
    */
    List<SysRole> selectSysRoleList(Page<SysRole> page);

    /**
    * 校验角色名是否唯一
    * @param roleName
    * @return
    */
    String checkSysRoleName(String roleName);
}

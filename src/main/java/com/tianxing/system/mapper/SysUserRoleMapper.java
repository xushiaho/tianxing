package com.tianxing.system.mapper;

import com.tianxing.system.entity.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
/**
 * <p>
 * 用户和角色关联表 Mapper 接口
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-30
 */
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

    /**
    * 查询用户和角色关联表列表
    * @param page
    * @return
    */
    List<SysUserRole> selectSysUserRoleList(Page<SysUserRole> page);

     /**
     * 校验用户名是否唯一
     * @param userName
     * @return
     */
     int checkSysUserRoleName(String userName);
 }

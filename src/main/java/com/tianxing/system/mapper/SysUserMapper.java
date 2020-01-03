package com.tianxing.system.mapper;

import com.tianxing.system.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-30
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
    * 查询用户信息表列表
    * @param page
    * @return
    */
    List<SysUser> selectSysUserList(Page<SysUser> page);

    /**
     * 新增用户
     * @param sysUser
     * @return
     */
    int insertSysUser(SysUser sysUser);

    /**
     * 修改用户
     * @param sysUser
     * @return
     */
    int updateSysUser(SysUser sysUser);

    /**
     * 校验用户名是否唯一
     * @param userName
     * @return
     */
     int checkSysUserName(String userName);
 }

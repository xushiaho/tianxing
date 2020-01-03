package com.tianxing.system.service;

import com.tianxing.system.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-30
 */
public interface ISysUserService extends IService<SysUser> {

    /**
    * 查询用户信息表列表
    * @param page
    * @return
    */
    List<SysUser> selectSysUserList(Page<SysUser> page);

    /**
     * 新增用户信息
     * @param sysUser
     * @return
     */
    int insertSysUser(SysUser sysUser);

    /**
     * 修改用户信息
     *
     * @param sysUser 用户信息
     * @return 结果
     */
    int updateSysUser(SysUser sysUser);

    /**
     * 根据用户id删除用户信息
     * @param userId
     * @return 结果
     */
    int deleteSysUserById(Long userId);

    /**
     * 批量删除用户信息
     *
     * @param userIds 需要删除的用户ID
     * @return 结果
     */
    int deleteSysUserByIds(Long[] userIds);

    /**
    * 校验用户名是否唯一
    * @param userName
    * @return
    */
    String checkSysUserName(String userName);
}

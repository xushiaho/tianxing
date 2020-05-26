package com.tianxing.system.service.impl;


import com.github.pagehelper.Page;
import com.tianxing.common.exception.MyException;
import com.tianxing.common.utils.CheckInformation;
import com.tianxing.system.entity.SysRole;
import com.tianxing.system.mapper.SysRoleMapper;
import com.tianxing.system.service.ISysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;
/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author 许仕昊
 * @since 2020-05-26
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    /**
    * 查询角色列表
    * @param sysRole
    * @return
    */
    @Override
    public Page<SysRole> selectSysRoleList(SysRole sysRole) {
        return sysRoleMapper.selectSysRoleList(sysRole);
    }

    /**
    * 新增角色
    * @param sysRole
    * @return
    */
    @Override
    public int saveSysRole(SysRole sysRole) {
        //合法验证
        if (sysRole == null){
            throw new MyException("保存对象不能为空");
        }

        if (StringUtils.isEmpty(sysRole.getRoleName())){
            throw new MyException("角色名称不能为空");
        }

        //保存数据
        int rows = sysRoleMapper.insert(sysRole);

        return rows;
    }

    /**
    * 修改角色
    * @param sysRole
    * @return
    */
    @Override
    public int updateSysRole(SysRole sysRole) {
        //合法验证
        if (sysRole == null){
            throw new MyException("保存对象不能为空");
        }

        if (StringUtils.isEmpty(sysRole.getRoleName())){
            throw new MyException("角色名称不能为空");
        }

        int updateById;
        //更新数据
        try {
            updateById = sysRoleMapper.updateById(sysRole);
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyException("更新失败");
        }

        return updateById;
    }

    /**
    * 根据角色id删除角色
    * @param roleId
    * @return
    */
    @Override
    public int deleteSysRole(Long roleId) {
        //合法验证
        if (roleId == null || roleId <= 0){
            throw new MyException("数据不合法,roleId="+roleId);
        }

        //执行删除操作
        int deleteByIds = sysRoleMapper.deleteById(roleId);

        if(deleteByIds==0) {
            throw new MyException("此信息可能已经不存在");
        }

        return deleteByIds;
    }

    /**
    * 校验角色名是否唯一
    * @param roleName
    * @return
    */
    @Override
    public String checkSysRoleName(String roleName) {
        int count = sysRoleMapper.checkSysRoleName(roleName);
        if (count > 0){
            return CheckInformation.ROLE_NAME_NOT_UNIQUE;
        }
        return CheckInformation.ROLE_NAME_UNIQUE;
    }

}

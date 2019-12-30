package com.tianxing.system.service.impl;

import com.tianxing.common.utils.CheckInformation;
import com.tianxing.system.entity.SysRole;
import com.tianxing.system.mapper.SysRoleMapper;
import com.tianxing.system.service.ISysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-30
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    /**
    * 查询角色信息表列表
    * @param page
    * @return
    */
    @Override
    public List<SysRole> selectSysRoleList(Page<SysRole> page) {
        return sysRoleMapper.selectSysRoleList(page);
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

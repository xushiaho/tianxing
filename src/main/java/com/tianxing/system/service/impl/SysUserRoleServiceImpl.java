package com.tianxing.system.service.impl;

import com.tianxing.common.utils.CheckInformation;
import com.tianxing.system.entity.SysUserRole;
import com.tianxing.system.mapper.SysUserRoleMapper;
import com.tianxing.system.service.ISysUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 用户角色关联表  服务实现类
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-23
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    /**
    * 校验用户名是否唯一
    * @param userName
    * @return
    */
    @Override
    public String checkSysUserRoleName(String userName) {
        int count = sysUserRoleMapper.checkSysUserRoleName(userName);
        if (count > 0){
            return CheckInformation.USER_NAME_NOT_UNIQUE;
        }
        return CheckInformation.USER_NAME_UNIQUE;
    }

}

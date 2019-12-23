package com.tianxing.system.service.impl;

import com.tianxing.common.utils.CheckInformation;
import com.tianxing.system.entity.SysRoleMenu;
import com.tianxing.system.mapper.SysRoleMenuMapper;
import com.tianxing.system.service.ISysRoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 角色菜单关联表  服务实现类
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-23
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements ISysRoleMenuService {

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    /**
    * 校验角色名是否唯一
    * @param roleName
    * @return
    */
    @Override
    public String checkSysRoleMenuName(String roleName) {
        int count = sysRoleMenuMapper.checkSysRoleMenuName(roleName);
        if (count > 0){
            return CheckInformation.ROLE_NAME_NOT_UNIQUE;
        }
        return CheckInformation.ROLE_NAME_UNIQUE;
    }

}

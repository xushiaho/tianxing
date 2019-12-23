package com.tianxing.system.service.impl;

import com.tianxing.common.utils.CheckInformation;
import com.tianxing.system.entity.SysRoleDept;
import com.tianxing.system.mapper.SysRoleDeptMapper;
import com.tianxing.system.service.ISysRoleDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 角色和部门关联表 服务实现类
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-23
 */
@Service
public class SysRoleDeptServiceImpl extends ServiceImpl<SysRoleDeptMapper, SysRoleDept> implements ISysRoleDeptService {

    @Autowired
    private SysRoleDeptMapper sysRoleDeptMapper;

    /**
    * 校验角色名是否唯一
    * @param roleName
    * @return
    */
    @Override
    public String checkSysRoleDeptName(String roleName) {
        int count = sysRoleDeptMapper.checkSysRoleDeptName(roleName);
        if (count > 0){
            return CheckInformation.ROLE_NAME_NOT_UNIQUE;
        }
        return CheckInformation.ROLE_NAME_UNIQUE;
    }

}

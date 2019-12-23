package com.tianxing.system.mapper;

import com.tianxing.system.entity.SysRoleDept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 角色和部门关联表 Mapper 接口
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-23
 */
public interface SysRoleDeptMapper extends BaseMapper<SysRoleDept> {

     /**
     * 校验角色名是否唯一
     * @param roleName
     * @return
     */
     int checkSysRoleDeptName(String roleName);
 }

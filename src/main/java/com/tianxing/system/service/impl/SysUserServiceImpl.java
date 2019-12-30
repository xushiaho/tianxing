package com.tianxing.system.service.impl;

import com.tianxing.common.utils.CheckInformation;
import com.tianxing.system.entity.SysUser;
import com.tianxing.system.mapper.SysUserMapper;
import com.tianxing.system.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-30
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    /**
    * 查询用户信息表列表
    * @param page
    * @return
    */
    @Override
    public List<SysUser> selectSysUserList(Page<SysUser> page) {
        return sysUserMapper.selectSysUserList(page);
    }

    /**
    * 校验用户名是否唯一
    * @param userName
    * @return
    */
    @Override
    public String checkSysUserName(String userName) {
        int count = sysUserMapper.checkSysUserName(userName);
        if (count > 0){
            return CheckInformation.USER_NAME_NOT_UNIQUE;
        }
        return CheckInformation.USER_NAME_UNIQUE;
    }

}

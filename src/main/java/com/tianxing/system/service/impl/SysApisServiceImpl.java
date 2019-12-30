package com.tianxing.system.service.impl;

import com.tianxing.common.utils.CheckInformation;
import com.tianxing.system.entity.SysApis;
import com.tianxing.system.mapper.SysApisMapper;
import com.tianxing.system.service.ISysApisService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
/**
 * <p>
 * 接口表 服务实现类
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-30
 */
@Service
public class SysApisServiceImpl extends ServiceImpl<SysApisMapper, SysApis> implements ISysApisService {

    @Autowired
    private SysApisMapper sysApisMapper;

    /**
    * 查询接口表列表
    * @param page
    * @return
    */
    @Override
    public List<SysApis> selectSysApisList(Page<SysApis> page) {
        return sysApisMapper.selectSysApisList(page);
    }

    /**
    * 校验接口名是否唯一
    * @param apisName
    * @return
    */
    @Override
    public String checkSysApisName(String apisName) {
        int count = sysApisMapper.checkSysApisName(apisName);
        if (count > 0){
            return CheckInformation.APIS_NAME_NOT_UNIQUE;
        }
        return CheckInformation.APIS_NAME_UNIQUE;
    }

}

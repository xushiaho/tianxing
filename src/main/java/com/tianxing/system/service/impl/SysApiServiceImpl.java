package com.tianxing.system.service.impl;

import com.tianxing.common.utils.CheckInformation;
import com.tianxing.system.entity.SysApi;
import com.tianxing.system.mapper.SysApiMapper;
import com.tianxing.system.service.ISysApiService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 接口表 服务实现类
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-23
 */
@Service
public class SysApiServiceImpl extends ServiceImpl<SysApiMapper, SysApi> implements ISysApiService {

    @Autowired
    private SysApiMapper sysApiMapper;

    /**
    * 校验接口名是否唯一
    * @param apiName
    * @return
    */
    @Override
    public String checkSysApiName(String apiName) {
        int count = sysApiMapper.checkSysApiName(apiName);
        if (count > 0){
            return CheckInformation.API_NAME_NOT_UNIQUE;
        }
        return CheckInformation.API_NAME_UNIQUE;
    }

}

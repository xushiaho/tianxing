package com.tianxing.system.service.impl;

import com.tianxing.common.utils.CheckInformation;
import com.tianxing.system.entity.SysBug;
import com.tianxing.system.mapper.SysBugMapper;
import com.tianxing.system.service.ISysBugService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * bug表 服务实现类
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-23
 */
@Service
public class SysBugServiceImpl extends ServiceImpl<SysBugMapper, SysBug> implements ISysBugService {

    @Autowired
    private SysBugMapper sysBugMapper;

    /**
    * 校验bu名是否唯一
    * @param bugName
    * @return
    */
    @Override
    public String checkSysBugName(String bugName) {
        int count = sysBugMapper.checkSysBugName(bugName);
        if (count > 0){
            return CheckInformation.BUG_NAME_NOT_UNIQUE;
        }
        return CheckInformation.BUG_NAME_UNIQUE;
    }

}

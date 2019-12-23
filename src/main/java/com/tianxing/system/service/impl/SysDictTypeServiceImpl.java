package com.tianxing.system.service.impl;

import com.tianxing.common.utils.CheckInformation;
import com.tianxing.system.entity.SysDictType;
import com.tianxing.system.mapper.SysDictTypeMapper;
import com.tianxing.system.service.ISysDictTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 字典类型表 服务实现类
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-23
 */
@Service
public class SysDictTypeServiceImpl extends ServiceImpl<SysDictTypeMapper, SysDictType> implements ISysDictTypeService {

    @Autowired
    private SysDictTypeMapper sysDictTypeMapper;

    /**
    * 校验字典名是否唯一
    * @param dictName
    * @return
    */
    @Override
    public String checkSysDictTypeName(String dictName) {
        int count = sysDictTypeMapper.checkSysDictTypeName(dictName);
        if (count > 0){
            return CheckInformation.DICT_NAME_NOT_UNIQUE;
        }
        return CheckInformation.DICT_NAME_UNIQUE;
    }

}

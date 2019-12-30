package com.tianxing.system.service.impl;

import com.tianxing.common.utils.CheckInformation;
import com.tianxing.system.entity.SysDictData;
import com.tianxing.system.mapper.SysDictDataMapper;
import com.tianxing.system.service.ISysDictDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
/**
 * <p>
 * 字典数据表 服务实现类
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-30
 */
@Service
public class SysDictDataServiceImpl extends ServiceImpl<SysDictDataMapper, SysDictData> implements ISysDictDataService {

    @Autowired
    private SysDictDataMapper sysDictDataMapper;

    /**
    * 查询字典数据表列表
    * @param page
    * @return
    */
    @Override
    public List<SysDictData> selectSysDictDataList(Page<SysDictData> page) {
        return sysDictDataMapper.selectSysDictDataList(page);
    }

    /**
    * 校验字典名是否唯一
    * @param dictName
    * @return
    */
    @Override
    public String checkSysDictDataName(String dictName) {
        int count = sysDictDataMapper.checkSysDictDataName(dictName);
        if (count > 0){
            return CheckInformation.DICT_NAME_NOT_UNIQUE;
        }
        return CheckInformation.DICT_NAME_UNIQUE;
    }

}

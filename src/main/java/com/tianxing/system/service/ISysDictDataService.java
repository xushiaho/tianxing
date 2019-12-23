package com.tianxing.system.service;

import com.tianxing.system.entity.SysDictData;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 字典数据表 服务类
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-23
 */
public interface ISysDictDataService extends IService<SysDictData> {

    /**
    * 校验字典名是否唯一
    * @param dictName
    * @return
    */
    String checkSysDictDataName(String dictName);
}

package com.tianxing.system.service;

import com.tianxing.system.entity.SysDictType;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 字典类型表 服务类
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-23
 */
public interface ISysDictTypeService extends IService<SysDictType> {

    /**
    * 校验字典名是否唯一
    * @param dictName
    * @return
    */
    String checkSysDictTypeName(String dictName);
}

package com.tianxing.system.service;

import com.tianxing.system.entity.SysBug;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * bug表 服务类
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-23
 */
public interface ISysBugService extends IService<SysBug> {

    /**
    * 校验bu名是否唯一
    * @param bugName
    * @return
    */
    String checkSysBugName(String bugName);
}

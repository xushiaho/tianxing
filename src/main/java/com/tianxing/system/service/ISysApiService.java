package com.tianxing.system.service;

import com.tianxing.system.entity.SysApi;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 接口表 服务类
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-23
 */
public interface ISysApiService extends IService<SysApi> {

    /**
    * 校验接口名是否唯一
    * @param apiName
    * @return
    */
    String checkSysApiName(String apiName);
}

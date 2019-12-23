package com.tianxing.system.mapper;

import com.tianxing.system.entity.SysApi;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 接口表 Mapper 接口
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-23
 */
public interface SysApiMapper extends BaseMapper<SysApi> {

     /**
     * 校验接口名是否唯一
     * @param apiName
     * @return
     */
     int checkSysApiName(String apiName);
 }

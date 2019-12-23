package com.tianxing.system.mapper;

import com.tianxing.system.entity.SysBug;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * bug表 Mapper 接口
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-23
 */
public interface SysBugMapper extends BaseMapper<SysBug> {

     /**
     * 校验bu名是否唯一
     * @param bugName
     * @return
     */
     int checkSysBugName(String bugName);
 }

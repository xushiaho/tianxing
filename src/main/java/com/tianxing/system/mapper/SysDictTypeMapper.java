package com.tianxing.system.mapper;

import com.tianxing.system.entity.SysDictType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 字典类型表 Mapper 接口
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-23
 */
public interface SysDictTypeMapper extends BaseMapper<SysDictType> {

     /**
     * 校验字典名是否唯一
     * @param dictName
     * @return
     */
     int checkSysDictTypeName(String dictName);
 }

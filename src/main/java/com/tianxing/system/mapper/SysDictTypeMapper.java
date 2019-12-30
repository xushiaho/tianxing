package com.tianxing.system.mapper;

import com.tianxing.system.entity.SysDictType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
/**
 * <p>
 * 字典类型表 Mapper 接口
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-30
 */
public interface SysDictTypeMapper extends BaseMapper<SysDictType> {

    /**
    * 查询字典类型表列表
    * @param page
    * @return
    */
    List<SysDictType> selectSysDictTypeList(Page<SysDictType> page);

     /**
     * 校验字典名是否唯一
     * @param dictName
     * @return
     */
     int checkSysDictTypeName(String dictName);
 }

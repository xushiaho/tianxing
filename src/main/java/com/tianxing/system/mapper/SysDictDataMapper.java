package com.tianxing.system.mapper;

import com.tianxing.system.entity.SysDictData;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
/**
 * <p>
 * 字典数据表 Mapper 接口
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-30
 */
public interface SysDictDataMapper extends BaseMapper<SysDictData> {

    /**
    * 查询字典数据表列表
    * @param page
    * @return
    */
    List<SysDictData> selectSysDictDataList(Page<SysDictData> page);

     /**
     * 校验字典名是否唯一
     * @param dictName
     * @return
     */
     int checkSysDictDataName(String dictName);
 }

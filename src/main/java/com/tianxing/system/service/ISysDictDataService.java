package com.tianxing.system.service;

import com.tianxing.system.entity.SysDictData;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
/**
 * <p>
 * 字典数据表 服务类
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-30
 */
public interface ISysDictDataService extends IService<SysDictData> {

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
    String checkSysDictDataName(String dictName);
}

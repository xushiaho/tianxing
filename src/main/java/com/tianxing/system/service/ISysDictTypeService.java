package com.tianxing.system.service;

import com.tianxing.system.entity.SysDictType;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
/**
 * <p>
 * 字典类型表 服务类
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-30
 */
public interface ISysDictTypeService extends IService<SysDictType> {

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
    String checkSysDictTypeName(String dictName);
}

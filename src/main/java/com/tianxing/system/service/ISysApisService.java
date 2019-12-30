package com.tianxing.system.service;

import com.tianxing.system.entity.SysApis;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
/**
 * <p>
 * 接口表 服务类
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-30
 */
public interface ISysApisService extends IService<SysApis> {

    /**
    * 查询接口表列表
    * @param page
    * @return
    */
    List<SysApis> selectSysApisList(Page<SysApis> page);

    /**
    * 校验接口名是否唯一
    * @param apisName
    * @return
    */
    String checkSysApisName(String apisName);
}

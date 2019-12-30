package com.tianxing.system.service;

import com.tianxing.system.entity.SysBugs;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
/**
 * <p>
 * bug表 服务类
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-30
 */
public interface ISysBugsService extends IService<SysBugs> {

    /**
    * 查询bug表列表
    * @param page
    * @return
    */
    List<SysBugs> selectSysBugsList(Page<SysBugs> page);

    /**
    * 校验bu名是否唯一
    * @param bugsName
    * @return
    */
    String checkSysBugsName(String bugsName);
}

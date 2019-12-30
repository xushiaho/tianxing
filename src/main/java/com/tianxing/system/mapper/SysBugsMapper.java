package com.tianxing.system.mapper;

import com.tianxing.system.entity.SysBugs;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
/**
 * <p>
 * bug表 Mapper 接口
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-30
 */
public interface SysBugsMapper extends BaseMapper<SysBugs> {

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
     int checkSysBugsName(String bugsName);
 }

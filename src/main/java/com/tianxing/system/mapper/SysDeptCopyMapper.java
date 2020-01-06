package com.tianxing.system.mapper;

import com.tianxing.system.entity.SysDeptCopy;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 *
 * @author 许仕昊
 * @since 2020-01-06
 */
public interface SysDeptCopyMapper extends BaseMapper<SysDeptCopy> {

    /**
    * 查询部门表列表
    * @param page
    * @return
    */
    List<SysDeptCopy> selectSysDeptCopyList(Page<SysDeptCopy> page);

     /**
     * 校验部门名是否唯一
     * @param deptName
     * @return
     */
     int checkSysDeptCopyName(String deptName);
 }

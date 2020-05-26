package com.tianxing.system.mapper;

import com.github.pagehelper.Page;
import com.tianxing.system.entity.SysDept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 *
 * @author 许仕昊
 * @since 2020-05-21
 */
public interface SysDeptMapper extends BaseMapper<SysDept> {

    /**
    * 查询部门表列表
    * @param sysDept
    * @return
    */
    List<SysDept> selectSysDeptList(SysDept sysDept);

    Page<SysDept> selectList(SysDept sysDept);
     /**
     * 校验部门名是否唯一
     * @param deptName
     * @return
     */
     int checkSysDeptName(String deptName);
 }

package com.tianxing.system.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.tianxing.system.entity.SysDept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 *
 * @author 许仕昊
 * @since 2020-01-07
 */
public interface SysDeptMapper extends BaseMapper<SysDept> {

    /**
    * 查询部门表列表
    * @param page
    * @return
    */
    List<SysDept> selectSysDeptList(Page<SysDept> page);

    /**
     * 查询留二标
     * @param page
     * @param sysDept
     * @return
     */
    List<SysDept> selectsysDept(Page<SysDept> page, @Param("sysDept") SysDept sysDept);

     /**
     * 校验部门名是否唯一
     * @param deptName
     * @return
     */
     int checkSysDeptName(String deptName);
 }

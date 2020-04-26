package com.tianxing.system.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.tianxing.common.entity.PageVo;
import com.tianxing.system.entity.SysDept;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author 许仕昊
 * @since 2020-01-07
 */
public interface ISysDeptService extends IService<SysDept> {

    /**
    * 查询部门表列表
    * @param page
    * @return
    */
    List<SysDept> selectSysDeptList(Page<SysDept> page);

    Page selectsysDept(SysDept sysDept, PageVo pageVo);

    /**
    * 新增部门
    * @param sysDept
    * @return
    */
    int saveSysDept(SysDept sysDept);

    /**
    * 修改部门
    * @param sysDept
    * @return
    */
    int updateSysDept(SysDept sysDept);

    /**
    * 根据部门id删除部门
    * @param deptId
    * @return
    */
    int deleteSysDept(Long deptId);

    /**
    * 校验部门名是否唯一
    * @param deptName
    * @return
    */
    String checkSysDeptName(String deptName);
}

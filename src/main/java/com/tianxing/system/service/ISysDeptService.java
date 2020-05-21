package com.tianxing.system.service;

import com.tianxing.system.entity.SysDept;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author 许仕昊
 * @since 2020-05-21
 */
public interface ISysDeptService extends IService<SysDept> {

    /**
    * 查询部门表列表
    * @param sysDept
    * @return
    */
    List<SysDept> selectSysDeptList(SysDept sysDept);

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

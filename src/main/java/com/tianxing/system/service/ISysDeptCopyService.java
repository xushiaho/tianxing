package com.tianxing.system.service;

import com.tianxing.system.entity.SysDeptCopy;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author 许仕昊
 * @since 2020-01-06
 */
public interface ISysDeptCopyService extends IService<SysDeptCopy> {

    /**
    * 查询部门表列表
    * @param page
    * @return
    */
    List<SysDeptCopy> selectSysDeptCopyList(Page<SysDeptCopy> page);

    /**
    * 新增部门
    * @param sysDeptCopy
    * @return
    */
    int saveSysDeptCopy(SysDeptCopy sysDeptCopy);

    /**
    * 修改部门
    * @param sysDeptCopy
    * @return
    */
    int updateSysDeptCopy(SysDeptCopy sysDeptCopy);

    /**
    * 根据部门id删除部门
    * @param deptId
    * @return
    */
    int deleteSysDeptCopy(Long deptId);

    /**
    * 校验部门名是否唯一
    * @param deptName
    * @return
    */
    String checkSysDeptCopyName(String deptName);
}

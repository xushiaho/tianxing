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
 * @since 2019-12-30
 */
public interface ISysDeptService extends IService<SysDept> {

    /**
    * 查询部门表列表
    * @param page
    * @return
    */
    List<SysDept> selectSysDeptList(Page<SysDept> page);

    /**
    * 校验部门名是否唯一
    * @param deptName
    * @return
    */
    String checkSysDeptName(String deptName);
}

package com.tianxing.system.service;

import com.tianxing.system.entity.SysDept;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tianxing.system.entity.VO.SysDeptZtreeVO;

import java.util.List;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-23
 */
public interface ISysDeptService extends IService<SysDept> {

    /**
    * 校验部门名是否唯一
    * @param deptName
    * @return
    */
    String checkSysDeptName(String deptName);

    /**
     * 部门节点
     * @return
     */
    List<SysDeptZtreeVO> findSysDeptZtree();
}

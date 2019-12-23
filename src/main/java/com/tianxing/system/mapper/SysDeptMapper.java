package com.tianxing.system.mapper;

import com.tianxing.system.entity.SysDept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tianxing.system.entity.VO.SysDeptZtreeVO;

import java.util.List;

/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-23
 */
public interface SysDeptMapper extends BaseMapper<SysDept> {

     /**
     * 校验部门名是否唯一
     * @param deptName
     * @return
     */
     int checkSysDeptName(String deptName);

    /**
     * 部门节点
     * @return
     */
    List<SysDeptZtreeVO> findSysDeptZtree();
}

package com.tianxing.system.service.impl;

import com.tianxing.common.utils.CheckInformation;
import com.tianxing.system.entity.SysDept;
import com.tianxing.system.entity.VO.SysDeptZtreeVO;
import com.tianxing.system.mapper.SysDeptMapper;
import com.tianxing.system.service.ISysDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-23
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements ISysDeptService {

    @Autowired
    private SysDeptMapper sysDeptMapper;

    /**
    * 校验部门名是否唯一
    * @param deptName
    * @return
    */
    @Override
    public String checkSysDeptName(String deptName) {
        int count = sysDeptMapper.checkSysDeptName(deptName);
        if (count > 0){
            return CheckInformation.DEPT_NAME_NOT_UNIQUE;
        }
        return CheckInformation.DEPT_NAME_UNIQUE;
    }

    /**
     * 部门节点
     * @return
     */
    @Override
    public List<SysDeptZtreeVO> findSysDeptZtree() {
        return sysDeptMapper.findSysDeptZtree();
    }

}

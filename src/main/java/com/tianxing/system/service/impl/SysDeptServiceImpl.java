package com.tianxing.system.service.impl;

import com.tianxing.common.exception.MyException;
import com.tianxing.common.utils.CheckInformation;
import com.tianxing.system.entity.SysDeptCopy;
import com.tianxing.system.mapper.SysDeptCopyMapper;
import com.tianxing.system.service.ISysDeptCopyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.util.StringUtils;

import java.util.List;
/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author 许仕昊
 * @since 2020-01-06
 */
@Service
public class SysDeptCopyServiceImpl extends ServiceImpl<SysDeptCopyMapper, SysDeptCopy> implements ISysDeptCopyService {

    @Autowired
    private SysDeptCopyMapper sysDeptCopyMapper;

    /**
    * 查询部门列表
    * @param page
    * @return
    */
    @Override
    public List<SysDeptCopy> selectSysDeptCopyList(Page<SysDeptCopy> page) {
        return sysDeptCopyMapper.selectSysDeptCopyList(page);
    }

    /**
    * 新增部门
    * @param sysDeptCopy
    * @return
    */
    @Override
    public int saveSysDeptCopy(SysDeptCopy sysDeptCopy) {
        //合法验证
        if (sysDeptCopy == null){
            throw new MyException("保存对象不能为空");
        }

        if (StringUtils.isEmpty(sysDeptCopy.getDeptName())){
            throw new MyException("部门名称不能为空");
        }

        //保存数据
        int rows = sysDeptCopyMapper.insert(sysDeptCopy);

        return rows;
    }

    /**
    * 修改部门
    * @param sysDeptCopy
    * @return
    */
    @Override
    public int updateSysDeptCopy(SysDeptCopy sysDeptCopy) {
        //合法验证
        if (sysDeptCopy == null){
            throw new MyException("保存对象不能为空");
        }

        if (StringUtils.isEmpty(sysDeptCopy.getDeptName())){
            throw new MyException("部门名称不能为空");
        }

        int updateById;
        //更新数据
        try {
            updateById = sysDeptCopyMapper.updateById(sysDeptCopy);
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyException("更新失败");
        }

        return updateById;
    }

    /**
    * 根据部门id删除部门
    * @param deptId
    * @return
    */
    @Override
    public int deleteSysDeptCopy(Long deptId) {
        //合法验证
        if (deptId == null || deptId <= 0){
            throw new MyException("数据不合法,deptId="+deptId);
        }

        //执行删除操作
        int deleteByIds = sysDeptCopyMapper.deleteById(deptId);

        if(deleteByIds==0) {
            throw new MyException("此信息可能已经不存在");
        }

        return deleteByIds;
    }

    /**
    * 校验部门名是否唯一
    * @param deptName
    * @return
    */
    @Override
    public String checkSysDeptCopyName(String deptName) {
        int count = sysDeptCopyMapper.checkSysDeptCopyName(deptName);
        if (count > 0){
            return CheckInformation.DEPT_NAME_NOT_UNIQUE;
        }
        return CheckInformation.DEPT_NAME_UNIQUE;
    }

}

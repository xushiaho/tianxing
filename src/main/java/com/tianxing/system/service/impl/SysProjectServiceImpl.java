package com.tianxing.system.service.impl;

import com.tianxing.common.utils.CheckInformation;
import com.tianxing.system.entity.SysProject;
import com.tianxing.system.mapper.SysProjectMapper;
import com.tianxing.system.service.ISysProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
/**
 * <p>
 * 项目表 服务实现类
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-30
 */
@Service
public class SysProjectServiceImpl extends ServiceImpl<SysProjectMapper, SysProject> implements ISysProjectService {

    @Autowired
    private SysProjectMapper sysProjectMapper;

    /**
    * 查询项目表列表
    * @param page
    * @return
    */
    @Override
    public List<SysProject> selectSysProjectList(Page<SysProject> page) {
        return sysProjectMapper.selectSysProjectList(page);
    }

    /**
    * 校验项目名是否唯一
    * @param projName
    * @return
    */
    @Override
    public String checkSysProjectName(String projName) {
        int count = sysProjectMapper.checkSysProjectName(projName);
        if (count > 0){
            return CheckInformation.PROJ_NAME_NOT_UNIQUE;
        }
        return CheckInformation.PROJ_NAME_UNIQUE;
    }

}

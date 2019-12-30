package com.tianxing.system.service;

import com.tianxing.system.entity.SysProject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
/**
 * <p>
 * 项目表 服务类
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-30
 */
public interface ISysProjectService extends IService<SysProject> {

    /**
    * 查询项目表列表
    * @param page
    * @return
    */
    List<SysProject> selectSysProjectList(Page<SysProject> page);

    /**
    * 校验项目名是否唯一
    * @param projName
    * @return
    */
    String checkSysProjectName(String projName);
}

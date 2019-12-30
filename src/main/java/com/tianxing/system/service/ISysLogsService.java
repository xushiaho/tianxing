package com.tianxing.system.service;

import com.tianxing.system.entity.SysLogs;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
/**
 * <p>
 * 系统日志 服务类
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-30
 */
public interface ISysLogsService extends IService<SysLogs> {

    /**
    * 查询系统日志列表
    * @param page
    * @return
    */
    List<SysLogs> selectSysLogsList(Page<SysLogs> page);
}

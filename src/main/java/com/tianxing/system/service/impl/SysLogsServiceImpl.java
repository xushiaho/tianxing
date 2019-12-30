package com.tianxing.system.service.impl;

import com.tianxing.common.utils.CheckInformation;
import com.tianxing.system.entity.SysLogs;
import com.tianxing.system.mapper.SysLogsMapper;
import com.tianxing.system.service.ISysLogsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
/**
 * <p>
 * 系统日志 服务实现类
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-30
 */
@Service
public class SysLogsServiceImpl extends ServiceImpl<SysLogsMapper, SysLogs> implements ISysLogsService {

    @Autowired
    private SysLogsMapper sysLogsMapper;

    /**
    * 查询系统日志列表
    * @param page
    * @return
    */
    @Override
    public List<SysLogs> selectSysLogsList(Page<SysLogs> page) {
        return sysLogsMapper.selectSysLogsList(page);
    }

}

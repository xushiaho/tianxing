package com.tianxing.system.mapper;

import com.tianxing.system.entity.SysLogs;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
/**
 * <p>
 * 系统日志 Mapper 接口
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-30
 */
public interface SysLogsMapper extends BaseMapper<SysLogs> {

    /**
    * 查询系统日志列表
    * @param page
    * @return
    */
    List<SysLogs> selectSysLogsList(Page<SysLogs> page);

     /**
     * 校验系统名是否唯一
     * @param logsName
     * @return
     */
     int checkSysLogsName(String logsName);
 }

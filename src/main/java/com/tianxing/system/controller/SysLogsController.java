package com.tianxing.system.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tianxing.common.enumeration.ApiResult;
import com.tianxing.common.utils.CheckInformation;
import com.tianxing.common.utils.DateUtils;
import com.tianxing.system.entity.SysLogs;
import com.tianxing.system.service.ISysLogsService;
import org.springframework.web.bind.annotation.RestController;
import com.tianxing.common.controller.BaseController;
import java.util.Arrays;

/**
 * <p>
 * 系统日志 前端控制器
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-30
 */
@RestController
@RequestMapping("/system/sysLogs/")
public class SysLogsController extends BaseController {

    @Autowired
    private ISysLogsService iSysLogsService;

    /**
    * 查询系统列表
    * @return
    */
    @RequestMapping(value = "list", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult list(){
        Page< SysLogs> page = new Page< SysLogs>();
        return new ApiResult(iSysLogsService.selectSysLogsList(page));
    }

    /**
    * 批量删除系统信息
    * @param sysLogsIds
    * @return
    */
    @RequestMapping(value = "deletes/{sysLogsId}", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult deletes(@PathVariable("sysLogsId") String[] sysLogsIds){
        iSysLogsService.removeByIds(Arrays.asList(sysLogsIds));
        return new ApiResult("删除成功");
    }


}

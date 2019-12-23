package com.tianxing.system.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tianxing.common.enumeration.ApiResult;
import com.tianxing.common.utils.CheckInformation;
import com.tianxing.common.utils.DateUtils;
import com.tianxing.system.entity.SysApi;
import com.tianxing.system.service.ISysApiService;
import org.springframework.web.bind.annotation.RestController;
import com.tianxing.common.controller.BaseController;
import java.util.Arrays;

/**
 * <p>
 * 接口表 前端控制器
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-23
 */
@RestController
@RequestMapping("/system/sysApi/")
public class SysApiController extends BaseController {

    @Autowired
    private ISysApiService iSysApiService;

    /**
    * 查询接口列表
    * @return
    */
    @RequestMapping(value = "list", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult list(){
        Page< SysApi> page = new Page< SysApi>();
        return new ApiResult(iSysApiService.page(page, Wrappers.emptyWrapper()));
    }

    /**
    * 新增接口信息
    *
    * @param sysApi
    * @return
    */
    @RequestMapping(value = "add", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult add ( SysApi  sysApi){

        //添加时间
        sysApi.setCreateTime(DateUtils.getNowDate());

        //校验接口名是否唯一
        if (CheckInformation.API_NAME_NOT_UNIQUE.equals(iSysApiService.checkSysApiName(sysApi.getApiname()))){
        return new ApiResult("新增接口"+sysApi.getApiname()+"失败,接口名已存在");
        }

        //添加接口信息
        iSysApiService.save(sysApi);
        return ApiResult.ok("添加成功!");
    }

    /**
    * 修改接口信息
    * @param sysApi
    * @return
    */
    @RequestMapping(value = "update", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult update(SysApi  sysApi){

        //修改时间
        sysApi.setUpdateTime(DateUtils.getNowDate());

        //校验接口名是否唯一
        if (CheckInformation.API_NAME_NOT_UNIQUE.equals(iSysApiService.checkSysApiName(sysApi.getApiname()))){
        return new ApiResult("修改接口"+sysApi.getApiname()+"失败,接口名已存在");
        }

        //修改接口信息
        iSysApiService.updateById(sysApi);
        return ApiResult.ok("修改成功!");
    }

    /**
    * 批量删除接口信息
    * @param sysApiIds
    * @return
    */
    @RequestMapping(value = "deletes/{sysApiId}", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult deletes(@PathVariable("sysApiId") String[] sysApiIds){
        iSysApiService.removeByIds(Arrays.asList(sysApiIds));
        return new ApiResult("删除成功");
    }


}

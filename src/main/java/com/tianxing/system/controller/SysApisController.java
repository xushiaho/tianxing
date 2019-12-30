package com.tianxing.system.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tianxing.common.enumeration.ApiResult;
import com.tianxing.common.utils.CheckInformation;
import com.tianxing.common.utils.DateUtils;
import com.tianxing.system.entity.SysApis;
import com.tianxing.system.service.ISysApisService;
import org.springframework.web.bind.annotation.RestController;
import com.tianxing.common.controller.BaseController;
import java.util.Arrays;

/**
 * <p>
 * 接口表 前端控制器
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-30
 */
@RestController
@RequestMapping("/system/sysApis/")
public class SysApisController extends BaseController {

    @Autowired
    private ISysApisService iSysApisService;

    /**
    * 查询接口列表
    * @return
    */
    @RequestMapping(value = "list", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult list(){
        Page< SysApis> page = new Page< SysApis>();
        return new ApiResult(iSysApisService.selectSysApisList(page));
    }

    /**
    * 新增接口信息
    *
    * @param sysApis
    * @return
    */
    @RequestMapping(value = "add", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult add ( SysApis  sysApis){

        //添加时间
        sysApis.setCreateTime(DateUtils.getNowDate());

        //校验接口名是否唯一
        if (CheckInformation.APIS_NAME_NOT_UNIQUE.equals(iSysApisService.checkSysApisName(sysApis.getApisName()))){
        return new ApiResult("新增接口"+sysApis.getApisName()+"失败,接口名已存在");
        }

        //添加接口信息
        iSysApisService.save(sysApis);
        return ApiResult.ok("添加成功!");
    }

    /**
    * 修改接口信息
    * @param sysApis
    * @return
    */
    @RequestMapping(value = "update", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult update(SysApis  sysApis){

        //修改时间
        sysApis.setUpdateTime(DateUtils.getNowDate());

        //校验接口名是否唯一
        if (CheckInformation.APIS_NAME_NOT_UNIQUE.equals(iSysApisService.checkSysApisName(sysApis.getApisName()))){
        return new ApiResult("修改接口"+sysApis.getApisName()+"失败,接口名已存在");
        }

        //修改接口信息
        iSysApisService.updateById(sysApis);
        return ApiResult.ok("修改成功!");
    }

    /**
    * 批量删除接口信息
    * @param sysApisIds
    * @return
    */
    @RequestMapping(value = "deletes/{sysApisId}", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult deletes(@PathVariable("sysApisId") String[] sysApisIds){
        iSysApisService.removeByIds(Arrays.asList(sysApisIds));
        return new ApiResult("删除成功");
    }


}

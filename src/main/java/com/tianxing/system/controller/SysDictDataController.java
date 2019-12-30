package com.tianxing.system.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tianxing.common.enumeration.ApiResult;
import com.tianxing.common.utils.CheckInformation;
import com.tianxing.common.utils.DateUtils;
import com.tianxing.system.entity.SysDictData;
import com.tianxing.system.service.ISysDictDataService;
import org.springframework.web.bind.annotation.RestController;
import com.tianxing.common.controller.BaseController;
import java.util.Arrays;

/**
 * <p>
 * 字典数据表 前端控制器
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-30
 */
@RestController
@RequestMapping("/system/sysDictData/")
public class SysDictDataController extends BaseController {

    @Autowired
    private ISysDictDataService iSysDictDataService;

    /**
    * 查询字典列表
    * @return
    */
    @RequestMapping(value = "list", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult list(){
        Page< SysDictData> page = new Page< SysDictData>();
        return new ApiResult(iSysDictDataService.selectSysDictDataList(page));
    }

    /**
    * 新增字典信息
    *
    * @param sysDictData
    * @return
    */
    @RequestMapping(value = "add", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult add ( SysDictData  sysDictData){

        //添加时间
        sysDictData.setCreateTime(DateUtils.getNowDate());

        //添加字典信息
        iSysDictDataService.save(sysDictData);
        return ApiResult.ok("添加成功!");
    }

    /**
    * 修改字典信息
    * @param sysDictData
    * @return
    */
    @RequestMapping(value = "update", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult update(SysDictData  sysDictData){

        //修改时间
        sysDictData.setUpdateTime(DateUtils.getNowDate());

        //修改字典信息
        iSysDictDataService.updateById(sysDictData);
        return ApiResult.ok("修改成功!");
    }

    /**
    * 批量删除字典信息
    * @param sysDictDataIds
    * @return
    */
    @RequestMapping(value = "deletes/{sysDictDataId}", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult deletes(@PathVariable("sysDictDataId") String[] sysDictDataIds){
        iSysDictDataService.removeByIds(Arrays.asList(sysDictDataIds));
        return new ApiResult("删除成功");
    }


}

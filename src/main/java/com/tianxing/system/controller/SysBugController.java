package com.tianxing.system.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tianxing.common.enumeration.ApiResult;
import com.tianxing.common.utils.CheckInformation;
import com.tianxing.common.utils.DateUtils;
import com.tianxing.system.entity.SysBug;
import com.tianxing.system.service.ISysBugService;
import org.springframework.web.bind.annotation.RestController;
import com.tianxing.common.controller.BaseController;
import java.util.Arrays;

/**
 * <p>
 * bug表 前端控制器
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-23
 */
@RestController
@RequestMapping("/system/sysBug/")
public class SysBugController extends BaseController {

    @Autowired
    private ISysBugService iSysBugService;

    /**
    * 查询bug列表
    * @return
    */
    @RequestMapping(value = "list", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult list(){
        Page< SysBug> page = new Page< SysBug>();
        return new ApiResult(iSysBugService.page(page, Wrappers.emptyWrapper()));
    }

    /**
    * 新增bug信息
    *
    * @param sysBug
    * @return
    */
    @RequestMapping(value = "add", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult add ( SysBug  sysBug){

        //添加时间
        sysBug.setCreateTime(DateUtils.getNowDate());

        //校验bug名是否唯一
        if (CheckInformation.BUG_NAME_NOT_UNIQUE.equals(iSysBugService.checkSysBugName(sysBug.getBugName()))){
        return new ApiResult("新增bu"+sysBug.getBugName()+"失败,bu名已存在");
        }

        //添加bu信息
        iSysBugService.save(sysBug);
        return ApiResult.ok("添加成功!");
    }

    /**
    * 修改bug信息
    * @param sysBug
    * @return
    */
    @RequestMapping(value = "update", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult update(SysBug  sysBug){

        //修改时间
        sysBug.setUpdateTime(DateUtils.getNowDate());

        //校验bug名是否唯一
        if (CheckInformation.BUG_NAME_NOT_UNIQUE.equals(iSysBugService.checkSysBugName(sysBug.getBugName()))){
        return new ApiResult("修改bu"+sysBug.getBugName()+"失败,bu名已存在");
        }

        //修改bug信息
        iSysBugService.updateById(sysBug);
        return ApiResult.ok("修改成功!");
    }

    /**
    * 批量删除bug信息
    * @param sysBugIds
    * @return
    */
    @RequestMapping(value = "deletes/{sysBugId}", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult deletes(@PathVariable("sysBugId") String[] sysBugIds){
        iSysBugService.removeByIds(Arrays.asList(sysBugIds));
        return new ApiResult("删除成功");
    }


}

package com.tianxing.system.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tianxing.common.enumeration.ApiResult;
import com.tianxing.common.utils.CheckInformation;
import com.tianxing.common.utils.DateUtils;
import com.tianxing.system.entity.SysDictType;
import com.tianxing.system.service.ISysDictTypeService;
import org.springframework.web.bind.annotation.RestController;
import com.tianxing.common.controller.BaseController;
import java.util.Arrays;

/**
 * <p>
 * 字典类型表 前端控制器
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-23
 */
@RestController
@RequestMapping("/system/sysDictType/")
public class SysDictTypeController extends BaseController {

    @Autowired
    private ISysDictTypeService iSysDictTypeService;

    /**
    * 查询字典列表
    * @return
    */
    @RequestMapping(value = "list", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult list(){
        Page< SysDictType> page = new Page< SysDictType>();
        return new ApiResult(iSysDictTypeService.page(page, Wrappers.emptyWrapper()));
    }

    /**
    * 新增字典信息
    *
    * @param sysDictType
    * @return
    */
    @RequestMapping(value = "add", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult add ( SysDictType  sysDictType){

        //添加时间
        sysDictType.setCreateTime(DateUtils.getNowDate());

        //校验字典名是否唯一
        if (CheckInformation.DICT_NAME_NOT_UNIQUE.equals(iSysDictTypeService.checkSysDictTypeName(sysDictType.getDictName()))){
        return new ApiResult("新增字典"+sysDictType.getDictName()+"失败,字典名已存在");
        }

        //添加字典信息
        iSysDictTypeService.save(sysDictType);
        return ApiResult.ok("添加成功!");
    }

    /**
    * 修改字典信息
    * @param sysDictType
    * @return
    */
    @RequestMapping(value = "update", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult update(SysDictType  sysDictType){

        //修改时间
        sysDictType.setUpdateTime(DateUtils.getNowDate());

        //校验字典名是否唯一
        if (CheckInformation.DICT_NAME_NOT_UNIQUE.equals(iSysDictTypeService.checkSysDictTypeName(sysDictType.getDictName()))){
        return new ApiResult("修改字典"+sysDictType.getDictName()+"失败,字典名已存在");
        }

        //修改字典信息
        iSysDictTypeService.updateById(sysDictType);
        return ApiResult.ok("修改成功!");
    }

    /**
    * 批量删除字典信息
    * @param sysDictTypeIds
    * @return
    */
    @RequestMapping(value = "deletes/{sysDictTypeId}", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult deletes(@PathVariable("sysDictTypeId") String[] sysDictTypeIds){
        iSysDictTypeService.removeByIds(Arrays.asList(sysDictTypeIds));
        return new ApiResult("删除成功");
    }


}

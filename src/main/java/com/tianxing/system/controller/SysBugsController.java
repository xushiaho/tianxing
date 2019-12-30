package com.tianxing.system.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tianxing.common.enumeration.ApiResult;
import com.tianxing.common.utils.CheckInformation;
import com.tianxing.common.utils.DateUtils;
import com.tianxing.system.entity.SysBugs;
import com.tianxing.system.service.ISysBugsService;
import org.springframework.web.bind.annotation.RestController;
import com.tianxing.common.controller.BaseController;
import java.util.Arrays;

/**
 * <p>
 * bug表 前端控制器
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-30
 */
@RestController
@RequestMapping("/system/sysBugs/")
public class SysBugsController extends BaseController {

    @Autowired
    private ISysBugsService iSysBugsService;

    /**
    * 查询bu列表
    * @return
    */
    @RequestMapping(value = "list", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult list(){
        Page< SysBugs> page = new Page< SysBugs>();
        return new ApiResult(iSysBugsService.selectSysBugsList(page));
    }

    /**
    * 新增bu信息
    *
    * @param sysBugs
    * @return
    */
    @RequestMapping(value = "add", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult add ( SysBugs  sysBugs){

        //添加时间
        sysBugs.setCreateTime(DateUtils.getNowDate());

        //校验bu名是否唯一
        if (CheckInformation.BUGS_NAME_NOT_UNIQUE.equals(iSysBugsService.checkSysBugsName(sysBugs.getBugsName()))){
        return new ApiResult("新增bu"+sysBugs.getBugsName()+"失败,bu名已存在");
        }

        //添加bu信息
        iSysBugsService.save(sysBugs);
        return ApiResult.ok("添加成功!");
    }

    /**
    * 修改bu信息
    * @param sysBugs
    * @return
    */
    @RequestMapping(value = "update", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult update(SysBugs  sysBugs){

        //修改时间
        sysBugs.setUpdateTime(DateUtils.getNowDate());

        //校验bu名是否唯一
        if (CheckInformation.BUGS_NAME_NOT_UNIQUE.equals(iSysBugsService.checkSysBugsName(sysBugs.getBugsName()))){
        return new ApiResult("修改bu"+sysBugs.getBugsName()+"失败,bu名已存在");
        }

        //修改bu信息
        iSysBugsService.updateById(sysBugs);
        return ApiResult.ok("修改成功!");
    }

    /**
    * 批量删除bu信息
    * @param sysBugsIds
    * @return
    */
    @RequestMapping(value = "deletes/{sysBugsId}", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult deletes(@PathVariable("sysBugsId") String[] sysBugsIds){
        iSysBugsService.removeByIds(Arrays.asList(sysBugsIds));
        return new ApiResult("删除成功");
    }


}

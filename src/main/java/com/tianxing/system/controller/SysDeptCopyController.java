package com.tianxing.system.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tianxing.common.enumeration.ApiResult;
import com.tianxing.common.utils.CheckInformation;
import com.tianxing.common.utils.DateUtils;
import com.tianxing.system.entity.SysDeptCopy;
import com.tianxing.system.service.ISysDeptCopyService;
import org.springframework.web.bind.annotation.RestController;
import com.tianxing.common.controller.BaseController;
import java.util.Arrays;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author 许仕昊
 * @since 2020-01-06
 */
@RestController
@RequestMapping("/system/sysDeptCopy/")
public class SysDeptCopyController extends BaseController {

    @Autowired
    private ISysDeptCopyService iSysDeptCopyService;

    /**
    * 查询部门列表
    * @return
    */
    @RequestMapping(value = "list", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult list(){
        Page< SysDeptCopy> page = new Page< SysDeptCopy>();
        return new ApiResult(iSysDeptCopyService.selectSysDeptCopyList(page));
    }

    /**
    * 新增部门信息
    *
    * @param sysDeptCopy
    * @return
    */
    @RequestMapping(value = "add", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult add ( SysDeptCopy  sysDeptCopy){

        //添加时间
        sysDeptCopy.setCreateTime(DateUtils.getNowDate());

        //校验部门名是否唯一
        if (CheckInformation.DEPT_NAME_NOT_UNIQUE.equals(iSysDeptCopyService.checkSysDeptCopyName(sysDeptCopy.getDeptName()))){
        return new ApiResult("新增部门"+sysDeptCopy.getDeptName()+"失败,部门名已存在");
        }

        //添加部门信息
        iSysDeptCopyService.saveSysDeptCopy(sysDeptCopy);
        return ApiResult.ok("添加成功!");
    }

    /**
    * 修改部门信息
    * @param sysDeptCopy
    * @return
    */
    @RequestMapping(value = "update", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult update(SysDeptCopy  sysDeptCopy){

        //修改时间
        sysDeptCopy.setUpdateTime(DateUtils.getNowDate());

        //校验部门名是否唯一
        if (CheckInformation.DEPT_NAME_NOT_UNIQUE.equals(iSysDeptCopyService.checkSysDeptCopyName(sysDeptCopy.getDeptName()))){
        return new ApiResult("修改部门"+sysDeptCopy.getDeptName()+"失败,部门名已存在");
        }

        //修改部门信息
        iSysDeptCopyService.updateSysDeptCopy(sysDeptCopy);
        return ApiResult.ok("修改成功!");
    }

    /**
    * 根据部门id删除部门
    * @param deptId
    * @return
    */
    @RequestMapping(value = "delete", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult delete(Long deptId){
        iSysDeptCopyService.deleteSysDeptCopy(deptId);
        return ApiResult.ok("删除成功");
    }

    /**
    * 批量删除部门信息
    * @param sysDeptCopyIds
    * @return
    */
    @RequestMapping(value = "deletes/{sysDeptCopyId}", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult deletes(@PathVariable("sysDeptCopyId") String[] sysDeptCopyIds){
        iSysDeptCopyService.removeByIds(Arrays.asList(sysDeptCopyIds));
        return new ApiResult("删除成功");
    }


}

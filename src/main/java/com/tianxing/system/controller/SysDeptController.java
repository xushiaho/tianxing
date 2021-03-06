package com.tianxing.system.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tianxing.common.enumeration.ApiResult;
import com.tianxing.common.utils.CheckInformation;
import com.tianxing.common.utils.DateUtils;
import com.tianxing.system.entity.SysDept;
import com.tianxing.system.service.ISysDeptService;
import org.springframework.web.bind.annotation.RestController;
import com.tianxing.common.controller.BaseController;
import java.util.*;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author 许仕昊
 * @since 2020-05-21
 */
@RestController
@RequestMapping("/system/sysDept/")
public class SysDeptController extends BaseController {

    @Autowired
    private ISysDeptService iSysDeptService;

    /**
    * 查询部门列表
    * @return
    */
    @RequestMapping(value = "list", produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<SysDept> list(SysDept sysDept){
        return iSysDeptService.selectSysDeptList(sysDept);
    }

    @RequestMapping(value = "list1", produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<SysDept> list1(Integer pageNum, Integer pageSize,SysDept sysDept){
        PageHelper.startPage(pageNum, pageSize);
        Page<SysDept> sysDepts = iSysDeptService.getUserList(sysDept);
        return sysDepts;
    }

    /**
    * 新增部门信息
    *
    * @param sysDept
    * @return
    */
    @RequestMapping(value = "add", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult add (SysDept sysDept){

        //添加时间
        sysDept.setCreateTime(DateUtils.getNowDate());

        //校验部门名是否唯一
        if (CheckInformation.DEPT_NAME_NOT_UNIQUE.equals(iSysDeptService.checkSysDeptName(sysDept.getDeptName()))){
        return ApiResult.ok("新增部门"+sysDept.getDeptName()+"失败,部门名已存在");
        }

        //添加部门信息
        iSysDeptService.saveSysDept(sysDept);
        return ApiResult.ok("添加成功!");
    }

    /**
    * 修改部门信息
    * @param sysDept
    * @return
    */
    @RequestMapping(value = "update", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult update(SysDept sysDept){

        //修改时间
        sysDept.setUpdateTime(DateUtils.getNowDate());

        //校验部门名是否唯一
        if (CheckInformation.DEPT_NAME_NOT_UNIQUE.equals(iSysDeptService.checkSysDeptName(sysDept.getDeptName()))){
        return ApiResult.ok("修改部门"+sysDept.getDeptName()+"失败,部门名已存在");
        }

        //修改部门信息
        iSysDeptService.updateSysDept(sysDept);
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
        iSysDeptService.deleteSysDept(deptId);
        return ApiResult.ok("删除成功");
    }

    /**
    * 批量删除部门信息
    * @param sysDeptIds
    * @return
    */
    @RequestMapping(value = "deletes/{sysDeptId}", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult deletes(@PathVariable("sysDeptId") String[] sysDeptIds){
        iSysDeptService.removeByIds(Arrays.asList(sysDeptIds));
        return ApiResult.ok("删除成功");
    }


}

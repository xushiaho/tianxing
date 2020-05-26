package com.tianxing.system.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tianxing.common.enumeration.ApiResult;
import com.tianxing.common.utils.CheckInformation;
import com.tianxing.common.utils.DateUtils;
import com.tianxing.system.entity.SysRole;
import com.tianxing.system.service.ISysRoleService;
import org.springframework.web.bind.annotation.RestController;
import com.tianxing.common.controller.BaseController;
import java.util.*;

/**
 * <p>
 * 角色信息表 前端控制器
 * </p>
 *
 * @author 许仕昊
 * @since 2020-05-26
 */
@RestController
@RequestMapping("/system/sysRole/")
public class SysRoleController extends BaseController {

    @Autowired
    private ISysRoleService iSysRoleService;

    /**
    * 查询角色列表
    * @return
    */
    @RequestMapping(value = "list", produces = "application/json;charset=utf-8")
    @ResponseBody
    public Page<SysRole> list(SysRole sysRole,Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        return iSysRoleService.selectSysRoleList(sysRole);
    }

    /**
    * 新增角色信息
    *
    * @param sysRole
    * @return
    */
    @RequestMapping(value = "add", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult add (SysRole sysRole){

        //添加时间
        sysRole.setCreateTime(DateUtils.getNowDate());

        //校验角色名是否唯一
        if (CheckInformation.ROLE_NAME_NOT_UNIQUE.equals(iSysRoleService.checkSysRoleName(sysRole.getRoleName()))){
        return new ApiResult("新增角色"+sysRole.getRoleName()+"失败,角色名已存在");
        }

        //添加角色信息
        iSysRoleService.saveSysRole(sysRole);
        return ApiResult.ok("添加成功!");
    }

    /**
    * 修改角色信息
    * @param sysRole
    * @return
    */
    @RequestMapping(value = "update", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult update(SysRole sysRole){

        //修改时间
        sysRole.setUpdateTime(DateUtils.getNowDate());

        //校验角色名是否唯一
        if (CheckInformation.ROLE_NAME_NOT_UNIQUE.equals(iSysRoleService.checkSysRoleName(sysRole.getRoleName()))){
        return new ApiResult("修改角色"+sysRole.getRoleName()+"失败,角色名已存在");
        }

        //修改角色信息
        iSysRoleService.updateSysRole(sysRole);
        return ApiResult.ok("修改成功!");
    }

    /**
    * 根据角色id删除角色
    * @param roleId
    * @return
    */
    @RequestMapping(value = "delete", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult delete(Long roleId){
        iSysRoleService.deleteSysRole(roleId);
        return ApiResult.ok("删除成功");
    }

    /**
    * 批量删除角色信息
    * @param sysRoleIds
    * @return
    */
    @RequestMapping(value = "deletes/{sysRoleId}", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult deletes(@PathVariable("sysRoleId") String[] sysRoleIds){
        iSysRoleService.removeByIds(Arrays.asList(sysRoleIds));
        return new ApiResult("删除成功");
    }


}

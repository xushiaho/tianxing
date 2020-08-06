package com.tianxing.system.controller;

import java.util.Date;

import com.tianxing.common.controller.BaseController;
import com.tianxing.common.enumeration.ApiResult;
import com.tianxing.page.PageRequest;
import com.tianxing.page.PageResult;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.tianxing.system.entity.SysMenu;
import com.tianxing.system.service.SysMenuService;

import java.util.*;

/**
 * 菜单权限表(SysMenu)表控制层
 *
 * @author 许仕昊
 * @since 2020-08-06 21:52:19
 */
@Api("菜单权限表")
@RestController
@RequestMapping("sysMenu/")
public class SysMenuController extends BaseController {
    
    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 查询菜单权限表列表信息
     *      
     * @param sysMenu
     * @return
     */
    @ApiOperation(value = "查询菜单权限表列表信息")
    @GetMapping(value = "list", produces = "application/json;charset=utf-8")
    public ApiResult list(SysMenu sysMenu){
        try {
            List<SysMenu> sysMenus = sysMenuService.selectSysMenuList(sysMenu);
            return ApiResult.ok("查询成功",sysMenus);
        }catch (Exception e) {
            e.printStackTrace();
            return ApiResult.fail("查询失败");
        }
    }

    /**
     * 分页查询菜单权限表列表信息
     *
     * @param pageQuery 分页对象
     * @param sysMenu
     * @return
     */
    @ApiOperation(value = "分页查询菜单权限表列表信息")
    @GetMapping(value = "listPage", produces = "application/json;charset=utf-8")
    public ApiResult findPage(PageRequest pageQuery,SysMenu sysMenu) {
        try {
            PageResult page = sysMenuService.selectSysMenuListPage(pageQuery, sysMenu);
            return ApiResult.ok("查询成功",page);
        }catch (Exception e){
            e.printStackTrace();
            return ApiResult.fail("查询失败");
        }
    }

    /**
     * 新增菜单权限表信息
     *
     * @param sysMenu
     * @return
     */
    @ApiOperation(value = "新增菜单权限表信息")
    @PostMapping(value = "add", produces = "application/json;charset=utf-8")
    public ApiResult add (SysMenu sysMenu){
        try {
            SysMenu sysMenu1 = sysMenu;
            //添加菜单信息
            sysMenuService.saveSysMenu(sysMenu1);
            return ApiResult.ok("添加成功!",sysMenu1);
        }catch (Exception e) {
            e.printStackTrace();
            return ApiResult.fail("添加失败");
        }
    }

    /**
     * 修改菜单权限表信息
     * @param sysMenu
     * @return
     */
    @ApiOperation(value = "修改菜单权限表信息")
    @PostMapping(value = "update", produces = "application/json;charset=utf-8")
    public ApiResult update(SysMenu sysMenu){
        try {
            SysMenu sysMenu1 = sysMenu;
            //修改菜单信息
            sysMenuService.updateSysMenu(sysMenu1);
            return ApiResult.ok("修改成功!",sysMenu1);
        }catch (Exception e) {
            e.printStackTrace();
            return ApiResult.fail("删除失败");
        }
    }


    /**
     * 根据菜单权限表id批量删除菜单权限表信息
     * @param menuIds
     * @return
     */
    @ApiOperation(value = "根据菜单权限表id批量删除菜单权限表信息")
    @PostMapping(value = "delete", produces = "application/json;charset=utf-8")
    public ApiResult deletes(Long[] menuIds){
        try {
            Long[] menuIds1 = menuIds;
            sysMenuService.deleteSysMenus(menuIds1);
            return ApiResult.ok("删除成功",menuIds1);
        }catch (Exception e) {
            e.printStackTrace();
            return ApiResult.fail("删除失败");
        }
    }
}
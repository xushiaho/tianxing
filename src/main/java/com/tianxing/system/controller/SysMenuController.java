package com.tianxing.system.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tianxing.page.PageRequest;
import io.github.yedaxia.apidocs.ApiDoc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tianxing.common.enumeration.ApiResult;
import com.tianxing.common.utils.CheckInformation;
import com.tianxing.common.utils.DateUtils;
import com.tianxing.system.entity.SysMenu;
import com.tianxing.system.service.ISysMenuService;
import org.springframework.web.bind.annotation.RestController;
import com.tianxing.common.controller.BaseController;
import java.util.*;

/**
 * <p>
 * 菜单权限表 前端控制器
 * </p>
 *
 * @author 许仕昊
 * @since 2020-05-26
 */

/**
 * 菜单表
 */
@Api("菜单")
@RestController
@RequestMapping("/system/sysMenu/")
public class SysMenuController extends BaseController {

    @Autowired
    private ISysMenuService iSysMenuService;

    /**
     *
     * @param sysMenu
     * @return
     */
    @ApiOperation(value = "菜单列表")
    @GetMapping(value = "list", produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<SysMenu> list(SysMenu sysMenu){
        return iSysMenuService.selectSysMenuList(sysMenu);
    }

    /**
     *
     * @param pageNum
     * @param pageSize
     * @param sysMenu
     * @return
     */
    @ApiOperation(value = "分页菜单列表")
    @GetMapping(value = "list1", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult<Page<SysMenu>> list1(Integer pageNum, Integer pageSize, SysMenu sysMenu){
        PageHelper.startPage(pageNum, pageSize);
        Page<SysMenu> sysMenus = iSysMenuService.selectList(sysMenu);
        return ApiResult.ok(sysMenus);
    }

    /**
    * 新增菜单信息
    *
    * @param sysMenu
    * @return
    */
    @ApiOperation(value = "新增菜单列表")
    @PostMapping(value = "add", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult add (SysMenu sysMenu){

        //添加时间
        sysMenu.setCreateTime(DateUtils.getNowDate());

        //校验菜单名是否唯一
        if (CheckInformation.MENU_NAME_NOT_UNIQUE.equals(iSysMenuService.checkSysMenuName(sysMenu.getMenuName()))){
        return ApiResult.ok("新增菜单"+sysMenu.getMenuName()+"失败,菜单名已存在");
        }

        //添加菜单信息
        iSysMenuService.saveSysMenu(sysMenu);
        return ApiResult.ok("添加成功!");
    }

    /**
    * 修改菜单信息
    * @param sysMenu
    * @return
    */
    @ApiOperation(value = "修改菜单列表")
    @PostMapping(value = "update", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult update(SysMenu sysMenu){

        //修改时间
        sysMenu.setUpdateTime(DateUtils.getNowDate());

        //校验菜单名是否唯一
        if (CheckInformation.MENU_NAME_NOT_UNIQUE.equals(iSysMenuService.checkSysMenuName(sysMenu.getMenuName()))){
        return ApiResult.ok("修改菜单"+sysMenu.getMenuName()+"失败,菜单名已存在");
        }

        //修改菜单信息
        iSysMenuService.updateSysMenu(sysMenu);
        return ApiResult.ok("修改成功!");
    }

    /**
    * 根据菜单id删除菜单
    * @param menuId
    * @return
    */
    @PostMapping(value = "delete", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult delete(Long menuId){
        iSysMenuService.deleteSysMenu(menuId);
        return ApiResult.ok("删除成功");
    }

    /**
    * 批量删除菜单信息
    * @param sysMenuIds
    * @return
    */
    @PostMapping(value = "deletes/{sysMenuId}", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult deletes(@PathVariable("sysMenuId") String[] sysMenuIds){
        iSysMenuService.removeByIds(Arrays.asList(sysMenuIds));
        return ApiResult.ok("删除成功");
    }

    @ApiOperation(value = "分页查询")
//    @PostMapping(value="/findPage")
    @PostMapping(value = "/findPage", produces = "application/json;charset=utf-8")
    public Object findPage(@RequestBody PageRequest pageQuery,SysMenu sysMenu) {
        return iSysMenuService.findPage(pageQuery,sysMenu);
    }
}

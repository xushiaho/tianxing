package com.tianxing.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 菜单权限表 前端控制器
 * </p>
 *
 * @author 许仕昊
 * @since 2020-04-26
 */
@RestController
@RequestMapping("/system/sysMenu/")
public class SysMenuController extends BaseController {

    @Autowired
    private ISysMenuService iSysMenuService;

    @RequestMapping("findAll")
    public List<Map> findAll(SysMenu sysMenu){
        return iSysMenuService.findAll(sysMenu);
    }

    @RequestMapping("findAll1")
    public List<SysMenu> findAll1(SysMenu sysMenu){
        return iSysMenuService.findAll1(sysMenu);
    }

    /**
     * 查询菜单列表
     * @return
     */
    @RequestMapping(value = "list", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult list(){
        Page< SysMenu> page = new Page< SysMenu>();
        return new ApiResult(iSysMenuService.selectSysMenuList(page));
    }

    /**
     * 新增菜单信息
     *
     * @param sysMenu
     * @return
     */
    @RequestMapping(value = "add", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult add (SysMenu sysMenu){

        //添加时间
        sysMenu.setCreateTime(DateUtils.getNowDate());

        //校验菜单名是否唯一
        if (CheckInformation.MENU_NAME_NOT_UNIQUE.equals(iSysMenuService.checkSysMenuName(sysMenu.getMenuName()))){
            return new ApiResult("新增菜单"+sysMenu.getMenuName()+"失败,菜单名已存在");
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
    @RequestMapping(value = "update", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult update(SysMenu sysMenu){

        //修改时间
        sysMenu.setUpdateTime(DateUtils.getNowDate());

        //校验菜单名是否唯一
        if (CheckInformation.MENU_NAME_NOT_UNIQUE.equals(iSysMenuService.checkSysMenuName(sysMenu.getMenuName()))){
            return new ApiResult("修改菜单"+sysMenu.getMenuName()+"失败,菜单名已存在");
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
    @RequestMapping(value = "delete", produces = "application/json;charset=utf-8")
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
    @RequestMapping(value = "deletes/{sysMenuId}", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult deletes(@PathVariable("sysMenuId") String[] sysMenuIds){
        iSysMenuService.removeByIds(Arrays.asList(sysMenuIds));
        return new ApiResult("删除成功");
    }


}

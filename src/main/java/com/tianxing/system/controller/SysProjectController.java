package com.tianxing.system.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tianxing.common.enumeration.ApiResult;
import com.tianxing.common.utils.CheckInformation;
import com.tianxing.common.utils.DateUtils;
import com.tianxing.system.entity.SysProject;
import com.tianxing.system.service.ISysProjectService;
import org.springframework.web.bind.annotation.RestController;
import com.tianxing.common.controller.BaseController;
import java.util.Arrays;

/**
 * <p>
 * 项目表 前端控制器
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-30
 */
@RestController
@RequestMapping("/system/sysProject/")
public class SysProjectController extends BaseController {

    @Autowired
    private ISysProjectService iSysProjectService;

    /**
    * 查询项目列表
    * @return
    */
    @RequestMapping(value = "list", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult list(){
        Page< SysProject> page = new Page< SysProject>();
        return new ApiResult(iSysProjectService.selectSysProjectList(page));
    }

    /**
    * 新增项目信息
    *
    * @param sysProject
    * @return
    */
    @RequestMapping(value = "add", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult add ( SysProject  sysProject){

        //添加时间
        sysProject.setCreateTime(DateUtils.getNowDate());

        //校验项目名是否唯一
        if (CheckInformation.PROJ_NAME_NOT_UNIQUE.equals(iSysProjectService.checkSysProjectName(sysProject.getProjectName()))){
        return new ApiResult("新增项目"+sysProject.getProjectName()+"失败,项目名已存在");
        }

        //添加项目信息
        iSysProjectService.save(sysProject);
        return ApiResult.ok("添加成功!");
    }

    /**
    * 修改项目信息
    * @param sysProject
    * @return
    */
    @RequestMapping(value = "update", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult update(SysProject  sysProject){

        //修改时间
        sysProject.setUpdateTime(DateUtils.getNowDate());

        //校验项目名是否唯一
        if (CheckInformation.PROJ_NAME_NOT_UNIQUE.equals(iSysProjectService.checkSysProjectName(sysProject.getProjectName()))){
        return new ApiResult("修改项目"+sysProject.getProjectName()+"失败,项目名已存在");
        }

        //修改项目信息
        iSysProjectService.updateById(sysProject);
        return ApiResult.ok("修改成功!");
    }

    /**
    * 批量删除项目信息
    * @param sysProjectIds
    * @return
    */
    @RequestMapping(value = "deletes/{sysProjectId}", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ApiResult deletes(@PathVariable("sysProjectId") String[] sysProjectIds){
        iSysProjectService.removeByIds(Arrays.asList(sysProjectIds));
        return new ApiResult("删除成功");
    }


}

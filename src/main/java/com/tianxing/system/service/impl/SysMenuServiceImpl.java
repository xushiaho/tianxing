package com.tianxing.system.service.impl;
import java.util.Arrays;
import java.util.Date;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianxing.common.exception.MyException;
import com.tianxing.common.utils.DateUtils;
import com.tianxing.page.PageRequest;
import com.tianxing.page.PageResult;
import com.tianxing.page.PageUtils;
import com.tianxing.system.mapper.SysMenuMapper;
import com.tianxing.system.entity.SysMenu;
import com.tianxing.system.service.SysMenuService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;


import java.util.List;

/**
 * 菜单权限表(SysMenu)表服务实现类
 *
 * @author 许仕昊
 * @since 2020-08-06 22:00:54
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;
    
    /**
    * 查询菜单权限表列表信息
    * @param sysMenu
    * @return
    */
    @Override
    public List<SysMenu> selectSysMenuList(SysMenu sysMenu) {
        return sysMenuMapper.selectSysMenuList(sysMenu);
    }

    /**
     * 分页模糊查询菜单权限表列表信息
     * @param pageRequest 分页
     * @param sysMenu 实体类对象
     * @return
     */
    @Override
    public PageResult selectSysMenuListPage(PageRequest pageRequest, SysMenu sysMenu) {
        return PageUtils.getPageResult(pageRequest,getPageInfo(pageRequest,sysMenu));
    }

    private PageInfo<SysMenu> getPageInfo(PageRequest pageRequest, SysMenu sysMenu) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<SysMenu> sysMenus = sysMenuMapper.selectSysMenuList(sysMenu);
        return new PageInfo<>(sysMenus);
    }

    /**
    * 新增菜单权限表信息
    * @param sysMenu
    * @return
    */
    @Override
    public void saveSysMenu(SysMenu sysMenu) {

        //添加时间
        sysMenu.setCreateTime(DateUtils.getNowDate());

        //保存数据
        sysMenuMapper.insert(sysMenu);

    }

    /**
    * 修改菜单
    * @param sysMenu
    * @return
    */
    @Override
    public void updateSysMenu(SysMenu sysMenu) {

        //修改时间
        sysMenu.setUpdateTime(DateUtils.getNowDate());

        sysMenuMapper.updateById(sysMenu);
    }

    
    /**
    * 根据id批量删除菜单权限表信息
    * @param menuIds
    * @return
    */    
    @Override
    public void deleteSysMenus(Long[] menuIds) {
        //合法验证
        if (menuIds == null || menuIds.length <= 0){
            throw new MyException("数据不合法,menuIds="+menuIds);
        }
        List<Long> longs = Arrays.asList(menuIds);
        //执行删除操作
        int i = sysMenuMapper.deleteBatchIds(longs);

        if(i==0) {
            throw new MyException("此信息可能已经不存在");
        }

    }
    


}
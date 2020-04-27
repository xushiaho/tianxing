package com.tianxing.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianxing.common.exception.MyException;
import com.tianxing.common.utils.CheckInformation;
import com.tianxing.system.entity.SysDept;
import com.tianxing.system.entity.SysMenu;
import com.tianxing.system.mapper.SysMenuMapper;
import com.tianxing.system.service.ISysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author 许仕昊
 * @since 2020-04-26
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;


    @Override
    public List<Map> findAll(Integer menuId) {
        Map map = new HashMap<>();
        map.put("menuId",menuId);
        return sysMenuMapper.findAll(map);
    }



    /**
    * 查询菜单列表
    * @param page
    * @return
    */
    @Override
    public List<SysMenu> selectSysMenuList(Page<SysMenu> page) {
        return sysMenuMapper.selectSysMenuList(page);
    }

    /**
    * 新增菜单
    * @param sysMenu
    * @return
    */
    @Override
    public int saveSysMenu(SysMenu sysMenu) {
        //合法验证
        if (sysMenu == null){
            throw new MyException("保存对象不能为空");
        }

        if (StringUtils.isEmpty(sysMenu.getMenuName())){
            throw new MyException("菜单名称不能为空");
        }

        //保存数据
        int rows = sysMenuMapper.insert(sysMenu);

        return rows;
    }

    /**
    * 修改菜单
    * @param sysMenu
    * @return
    */
    @Override
    public int updateSysMenu(SysMenu sysMenu) {
        //合法验证
        if (sysMenu == null){
            throw new MyException("保存对象不能为空");
        }

        if (StringUtils.isEmpty(sysMenu.getMenuName())){
            throw new MyException("菜单名称不能为空");
        }

        int updateById;
        //更新数据
        try {
            updateById = sysMenuMapper.updateById(sysMenu);
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyException("更新失败");
        }

        return updateById;
    }

    /**
    * 根据菜单id删除菜单
    * @param menuId
    * @return
    */
    @Override
    public int deleteSysMenu(Long menuId) {
        //合法验证
        if (menuId == null || menuId <= 0){
            throw new MyException("数据不合法,menuId="+menuId);
        }

        //执行删除操作
        int deleteByIds = sysMenuMapper.deleteById(menuId);

        if(deleteByIds==0) {
            throw new MyException("此信息可能已经不存在");
        }

        return deleteByIds;
    }

    /**
    * 校验菜单名是否唯一
    * @param menuName
    * @return
    */
    @Override
    public String checkSysMenuName(String menuName) {
        int count = sysMenuMapper.checkSysMenuName(menuName);
        if (count > 0){
            return CheckInformation.MENU_NAME_NOT_UNIQUE;
        }
        return CheckInformation.MENU_NAME_UNIQUE;
    }

}

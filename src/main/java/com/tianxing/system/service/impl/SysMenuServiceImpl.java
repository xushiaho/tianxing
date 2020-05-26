package com.tianxing.system.service.impl;

import com.github.pagehelper.Page;
import com.tianxing.common.exception.MyException;
import com.tianxing.common.utils.CheckInformation;
import com.tianxing.system.entity.SysMenu;
import com.tianxing.system.mapper.SysMenuMapper;
import com.tianxing.system.service.ISysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;
/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author 许仕昊
 * @since 2020-05-26
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    /**
    * 查询菜单列表
    * @param sysMenu
    * @return
    */
    @Override
    public List<SysMenu> selectSysMenuList(SysMenu sysMenu) {
        return sysMenuMapper.selectSysMenuList(sysMenu);
    }

    @Override
    public Page<SysMenu> selectList(SysMenu sysMenu) {
        //Page<SysMenu> sysMenus = sysMenuMapper.selectList(sysMenu);
        return sysMenuMapper.selectList(sysMenu);
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

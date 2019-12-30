package com.tianxing.system.service.impl;

import com.tianxing.common.utils.CheckInformation;
import com.tianxing.system.entity.SysMenu;
import com.tianxing.system.mapper.SysMenuMapper;
import com.tianxing.system.service.ISysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-30
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    /**
    * 查询菜单权限表列表
    * @param page
    * @return
    */
    @Override
    public List<SysMenu> selectSysMenuList(Page<SysMenu> page) {
        return sysMenuMapper.selectSysMenuList(page);
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

package com.tianxing.system.service.impl;

import com.tianxing.common.utils.CheckInformation;
import com.tianxing.system.entity.SysBugs;
import com.tianxing.system.mapper.SysBugsMapper;
import com.tianxing.system.service.ISysBugsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
/**
 * <p>
 * bug表 服务实现类
 * </p>
 *
 * @author 许仕昊
 * @since 2019-12-30
 */
@Service
public class SysBugsServiceImpl extends ServiceImpl<SysBugsMapper, SysBugs> implements ISysBugsService {

    @Autowired
    private SysBugsMapper sysBugsMapper;

    /**
    * 查询bug表列表
    * @param page
    * @return
    */
    @Override
    public List<SysBugs> selectSysBugsList(Page<SysBugs> page) {
        return sysBugsMapper.selectSysBugsList(page);
    }

    /**
    * 校验bu名是否唯一
    * @param bugsName
    * @return
    */
    @Override
    public String checkSysBugsName(String bugsName) {
        int count = sysBugsMapper.checkSysBugsName(bugsName);
        if (count > 0){
            return CheckInformation.BUGS_NAME_NOT_UNIQUE;
        }
        return CheckInformation.BUGS_NAME_UNIQUE;
    }

}

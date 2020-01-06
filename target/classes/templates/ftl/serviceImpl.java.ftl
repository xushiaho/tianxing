package ${package.ServiceImpl};

import com.tianxing.common.utils.CheckInformation;
import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    @Autowired
    private ${table.mapperName} ${table.mapperName?uncap_first};

    /**
    * 查询${table.comment!?substring(0,2)}列表
    * @param page
    * @return
    */
    @Override
    public List<${entity}> select${entity}List(Page<${entity}> page) {
        return ${table.mapperName?uncap_first}.select${entity}List(page);
    }

    /**
    * 新增${table.comment!?substring(0,2)}
    * @param ${entity?uncap_first}
    * @return
    */
    @Override
    public int save${entity}(${entity} ${entity?uncap_first}) {
    //合法验证
    if (${entity?uncap_first} == null){
    throw new MyException("保存对象不能为空");
    }
    if (StringUtils.isEmpty(${entity?uncap_first}.getDeptName())){
    throw new MyException("部门不能为空");
    }

    //保存数据
    int rows = sysDeptCopyMapper.insert(${entity?uncap_first});
    return rows;
    }

    /**
    * 修改${table.comment!?substring(0,2)}
    * @param ${entity?uncap_first}
    * @return
    */
    @Override
    public int update${entity}(${entity} ${entity?uncap_first}) {
    //合法验证
    if (${entity?uncap_first} == null){
    throw new MyException("保存对象不能为空");
    }
    if (StringUtils.isEmpty(${entity?uncap_first}.getDeptName())){
    throw new MyException("部门不能为空");
    }
    int updateById;
    //更新数据
    try {
    updateById = sysDeptCopyMapper.updateById(${entity?uncap_first});
    } catch (Exception e) {
    e.printStackTrace();
    throw new MyException("更新失败");
    }
    return updateById;
    }

    /**
    * 根据${table.comment!?substring(0,2)}id删除${table.comment!?substring(0,2)}
    * @param deptId
    * @return
    */
    @Override
    public int deleteObject(Long deptId) {
    //合法验证
    if (deptId == null || deptId <= 0){
    throw new MyException("数据不合法,deptId="+deptId);
    }
    //执行删除操作
    int deleteByIds = sysDeptCopyMapper.deleteById(deptId);
    if(deleteByIds==0) {
    throw new MyException("此信息可能已经不存在");
    }
    return deleteByIds;
    }

    /**
    * 校验${table.comment!?substring(0,2)}名是否唯一
    * @param ${entity[3..6]?uncap_first}Name
    * @return
    */
    @Override
    public String check${entity}Name(String ${entity[3..6]?uncap_first}Name) {
        int count = ${table.mapperName?uncap_first}.check${entity}Name(${entity[3..6]?uncap_first}Name);
        if (count > 0){
            return CheckInformation.${entity[3..6]?upper_case}_NAME_NOT_UNIQUE;
        }
        return CheckInformation.${entity[3..6]?upper_case}_NAME_UNIQUE;
    }

}
</#if>

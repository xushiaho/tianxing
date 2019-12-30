package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

    /**
    * 查询${table.comment!}列表
    * @param page
    * @return
    */
    List<${entity}> select${entity}List(Page<${entity}> page);

    /**
    * 校验${table.comment!?substring(0,2)}名是否唯一
    * @param ${entity[3..6]?uncap_first}Name
    * @return
    */
    String check${entity}Name(String ${entity[3..6]?uncap_first}Name);
}
</#if>

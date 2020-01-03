<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${package.Mapper}.${table.mapperName}">

    <#if enableCache>
        <!-- 开启二级缓存 -->
        <cache type="org.mybatis.caches.ehcache.LoggingEhcache"/>

    </#if>

    <!-- 通用查询映射结果 -->
    <resultMap id="BaseResultMap" type="${package.Entity}.${entity}">
        <#list table.fields as field>
            <#if field.keyFlag><#--生成主键排在第一位-->
        <id column="${field.name}"      property="${field.propertyName}"        />
            </#if>
        </#list>
        <#list table.fields as field>
            <#if !field.keyFlag><#--生成普通字段 -->
        <result column="${field.name}"      property="${field.propertyName}"    />
            </#if>
        </#list>
    </resultMap>

    <!-- 通用查询结果列 -->
    <sql id="select${entity}Vo">
        select ${table.fieldNames} from ${table.name}
        <#list table.commonFields as field>
            ${field.name},
        </#list>
    </sql>

    <!-- 查询${table.comment!?substring(0,2)}列表 -->
    <select id="select${entity}List" parameterType="${package.Entity}.${entity}" resultMap="BaseResultMap">
        <include refid="select${entity}Vo"/>
    </select>

    <!-- 新增${table.comment!?substring(0,2)}信息 -->
    <insert id="insertSysUser" parameterType="${package.Entity}.${entity}" useGeneratedKeys="true" keyProperty="userId">
        insert into ${table.name}
        <#list table.fields as field>
            <if test="${field.propertyName} != null and ${field.propertyName} != ''">${field.name},</if>
        </#list>
    </insert>

    <!-- 修改${table.comment!?substring(0,2)}信息 -->
    <update id="updateSysUser" parameterType="${package.Entity}.${entity}">

    </update>

    <!-- 校验${table.comment!?substring(0,2)}名是否唯一 -->
    <select id="check${entity}Name" parameterType="String" resultType="int">
        select count(1) from sys_${entity[3..6]?uncap_first} where ${entity[3..6]?uncap_first}Name=${entity[3..6]?uncap_first}Name
    </select>
</mapper>

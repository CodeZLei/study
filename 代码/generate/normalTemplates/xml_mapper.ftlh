<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//ibatis.apache.org//DTD Mapper 3.0//EN" "http://ibatis.apache.org/dtd/ibatis-3-mapper.dtd">

<!-- 代码自动生成 ${tableName} 的mapper文件 -->
<mapper namespace="${basePachage}.dao.${partCode}.${beanName}Mapper">

	<!-- 参数映射 -->
	<resultMap id="${beanName}RM" type="${basePachage}.domain.${partCode}.${beanName}">
<#list keyColumnList as column>
        <id property="${column.propertyName}" column="${column.columnCode}" javaType="${column.javaType}" jdbcType="${column.jdbcType}"/>
</#list>
<#list columnList as column>
    <#if !column.isPrimaryKey>
        <result property="${column.propertyName}" column="${column.columnCode}" javaType="${column.javaType}" jdbcType="${column.jdbcType}"/>
    </#if>
</#list>
    </resultMap>

    <!-- 表的所有字段 -->
    <sql id="allColumns">
        <![CDATA[
<#list columnList as column>
    <#if column_index+1 == columnList?size>
            ${column.columnCode}
    <#else>
            ${column.columnCode},
    </#if>
</#list>
        ]]>
    </sql>

    <!-- 表的主键字段 -->
    <sql id="pkColumns">
        <![CDATA[
<#list keyColumnList as column>
    <#if column_index+1 == keyColumnList?size>
            ${column.columnCode}
    <#else>
            ${column.columnCode},
    </#if>
</#list>
        ]]>
    </sql>

    <!-- 根据实体的查询对象进行查询的sql -->
    <sql id="querySql">
        select <include refid="allColumns" />
            from ${tableName}
            <where>
<#list columnList as column>
    <#if column.javaType == "Date" || column.javaType == "Double" || column.javaType == "Integer">
                <if test="${column.propertyName} != null">
                    <![CDATA[and ${column.columnCode} = ${r"#{"}${column.propertyName}}]]>
                </if>
                <if test="${column.propertyName}Start != null">
                    <![CDATA[and ${column.columnCode} >= ${r"#{"}${column.propertyName}Start}]]>
                </if>
                <if test="${column.propertyName}End != null">
                    <![CDATA[and ${column.columnCode} <= ${r"#{"}${column.propertyName}End}]]>
                </if>
    <#else>
                <if test="${column.propertyName} != null and ${column.propertyName} != ''">
                    <![CDATA[and ${column.columnCode} = ${r"#{"}${column.propertyName}}]]>
                </if>
    </#if>
</#list>
            </where>
    </sql>

    <!-- 新增数据 -->
    <insert id="insert" parameterType="${basePachage}.domain.${partCode}.${beanName}">
        <![CDATA[
            insert into ${tableName} (
<#list columnList as column>
    <#if column_index+1 == columnList?size>
                ${column.columnCode}
    <#else>
                ${column.columnCode},
    </#if>
</#list>
            ) values (
<#list columnList as column>
    <#if column_index+1 == columnList?size>
                ${r"#{"}${column.propertyName}}
    <#else>
                ${r"#{"}${column.propertyName}},
    </#if>
</#list>
            )
        ]]>
    </insert>

    <!-- 根据主键删除数据 -->
<#if havePk == "false">
        <!-- 此表没有主键或此表的列均属于主键 -->
<#else>
    <delete id="deleteByPrimaryKey" parameterType="${basePachage}.domain.${partCode}.${beanName}">
        <![CDATA[
            delete from ${tableName}
                where
    <#list keyColumnList as column>
        <#if column_index == 0>
                ${column.columnCode} = ${r"#{"}${column.propertyName}}
        <#else>
                and ${column.columnCode} = ${r"#{"}${column.propertyName}}
        </#if>
    </#list>
        ]]>
    </delete>
</#if>

    <!-- 根据主键更新数据 -->
    <update id="updateByPrimaryKeySelective" parameterType="${basePachage}.domain.${partCode}.${beanName}">
<#if havePk == "false">
        <!-- 此表没有主键或此表的列均属于主键 -->
<#else>
        update ${tableName}
            <set>
    <#list columnList as column>
        <#if !column.isPrimaryKey>
                <if test="${column.propertyName} != null"><![CDATA[${column.columnCode} = ${r"#{"}${column.propertyName}},]]></if>
        </#if>
    </#list>
            </set>
        where
    <#list keyColumnList as column>
        <#if column_index == 0>
                ${column.columnCode} = ${r"#{"}${column.propertyName}}
        <#else>
                and ${column.columnCode} = ${r"#{"}${column.propertyName}}
        </#if>
    </#list>
</#if>
    </update>
    <!-- 根据主键查询对象 -->
    <select id="selectByPrimaryKey" parameterType="${basePachage}.domain.${partCode}.${beanName}" resultMap="${beanName}RM">
<#if havePk == "false">
        <!-- 此表没有主键或此表的列均属于主键 -->
<#else>
        select <include refid="allColumns" />
        <![CDATA[
            from ${tableName}
            where
    <#list keyColumnList as column>
        <#if column_index == 0>
                ${column.columnCode} = ${r"#{"}${column.propertyName}}
        <#else>
                and ${column.columnCode} = ${r"#{"}${column.propertyName}}
        </#if>
    </#list>
        ]]>
</#if>
    </select>

    <!-- 根据实体对象查询数据结果集 -->
    <select id="selectByEntityQuery" parameterType="${basePachage}.domain.${partCode}.query.${beanName}Query" resultMap="${beanName}RM">
        <include refid="querySql"/>
        <if test="sortColumns != null and sortColumns != ''">
            order by ${r"${"}sortColumns}
        </if>
    </select>

</mapper>

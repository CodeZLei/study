package ${basePachage}.service.${partCode};

import java.util.List;

import ${basePachage}.domain.${partCode}.${beanName};
import ${basePachage}.domain.${partCode}.query.${beanName}Query;

/**
 * <pre>
 * <b>类描述:</b>${beanName}表对应的业务处理类。
 * <b>作者:</b>zhanglei29
 * <b>创建日期:</b>${dateStr}
 * </pre>
 */
public interface ${beanName}Service {

	/**
     * 插入数据库记录
     *
     * @param entity
     */
    int insert(${beanName} entity);

<#if havePk == "true">
	/**
     * 根据主键删除数据库的记录
     *
<#list keyColumnList as column>     
	 * @param ${column.propertyName}
</#list>
     */
    int deleteByPrimaryKey(<#list keyColumnList as column><#if column_index+1 == keyColumnList?size>${column.javaType} ${column.propertyName}<#else>${column.javaType} ${column.propertyName}, </#if></#list>);
    
    /**
     * 根据主键来更新部分数据库记录
     *
     * @param entity
     */
    int updateByPrimaryKeySelective(${beanName} entity);
    
    /**
     * 保存数据信息(更新/插入)
     * 
     * @param entity
     */
    int save(${beanName} entity);
    
    /**
     * 根据主键获取一条数据库记录
     *
<#list keyColumnList as column>     
	 * @param ${column.propertyName}
</#list>
     */
    ${beanName} selectByPrimaryKey(<#list keyColumnList as column><#if column_index+1 == keyColumnList?size>${column.javaType} ${column.propertyName}<#else>${column.javaType} ${column.propertyName}, </#if></#list>);
</#if>
  
    /**
     * 根据查询对象查找列表数据
     * 
     * @param entityQuery
     * @return 
     */
    List<${beanName}> selectByEntityQuery(${beanName}Query entityQuery);

}
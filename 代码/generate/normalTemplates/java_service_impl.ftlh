package ${basePachage}.service.${partCode}.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ${basePachage}.dao.${partCode}.${beanName}Mapper;
import ${basePachage}.domain.${partCode}.${beanName};
import ${basePachage}.domain.${partCode}.query.${beanName}Query;
import ${basePachage}.service.${partCode}.${beanName}Service;

/**
 * <pre>
 * <b>类描述:</b>${beanName}表对应的业务处理类。
 * <b>作者:</b>zhanglei29
 * <b>创建日期:</b>${dateStr}
 * </pre>
 */
@Service
public class ${beanName}ServiceImpl implements ${beanName}Service{

    private static final Logger LOGGER = LoggerFactory.getLogger(${beanName}Service.class);
	
	@Resource(name = "${beanName?uncap_first}Mapper")
	private ${beanName}Mapper ${beanName?uncap_first}Mapper;
	
	@Override
    public int insert(${beanName} entity){
    	return ${beanName?uncap_first}Mapper.insert(entity);
    }

<#if havePk == "true">   
	@Override
    public int deleteByPrimaryKey(<#list keyColumnList as column><#if column_index+1 == keyColumnList?size>${column.javaType} ${column.propertyName}<#else>${column.javaType} ${column.propertyName}, </#if></#list>){
    	return ${beanName?uncap_first}Mapper.deleteByPrimaryKey(<#list keyColumnList as column><#if column_index+1 == keyColumnList?size>${column.propertyName}<#else>${column.propertyName}, </#if></#list>);
    }

    @Override
    public int updateByPrimaryKeySelective(${beanName} entity){
    	return ${beanName?uncap_first}Mapper.updateByPrimaryKeySelective(entity);
    }
    
    @Override
    public int save(${beanName} entity) {
        if (<#list keyColumnList as column><#if column_index+1 == keyColumnList?size>null == entity.get${column.propertyName?cap_first}()<#else>null == entity.get${column.propertyName?cap_first}() || </#if></#list>) {
            entity.setCreateTime(new Date());
            entity.setLastUpdateTime(new Date());
            return this.insert(entity);
        } else {
            entity.setLastUpdateTime(new Date());
            return this.updateByPrimaryKeySelective(entity);
        }
    }

    @Override
    public ${beanName} selectByPrimaryKey(<#list keyColumnList as column><#if column_index+1 == keyColumnList?size>${column.javaType} ${column.propertyName}<#else>${column.javaType} ${column.propertyName}, </#if></#list>){
		return ${beanName?uncap_first}Mapper.selectByPrimaryKey(<#list keyColumnList as column><#if column_index+1 == keyColumnList?size>${column.propertyName}<#else>${column.propertyName}, </#if></#list>);    	
    }
    
</#if>

    @Override
    public List<${beanName}> selectByEntityQuery(${beanName}Query entityQuery){
		return ${beanName?uncap_first}Mapper.selectByEntityQuery(entityQuery);
    }
    
}

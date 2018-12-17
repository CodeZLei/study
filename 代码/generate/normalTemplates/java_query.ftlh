package ${basePachage}.domain.${partCode}.query;

<#-- #############################################    根据字段类型，导入特殊的包       ############################################# -->
  <#list columnList as column>
      <#if column.javaType == "Date">
import java.util.Date;
           <#break>
      </#if>
  </#list>

import ${basePachage}.domain.${partCode}.${beanName};

/**
 * <pre>
 * <b>类描述:</b>${beanName}表的对应的查询对象
 * <b>作者:</b>zhanglei29
 * <b>创建日期:</b>${dateStr}
 * </pre>
 */
public class ${beanName}Query extends ${beanName} {

    private static final long serialVersionUID = 1L;

<#-- #############################################    变量定义部分       ############################################# -->
  <#list columnList as column>
      <#if column.javaType == "Date" || column.javaType == "Double" || column.javaType == "Integer">
    /* 区间查询条件:${column.columnName}-开始 */
    private ${column.javaType} ${column.propertyName}Start;

    /* 区间查询条件:${column.columnName}-结束 */
    private ${column.javaType} ${column.propertyName}End;

      </#if>
  </#list>
    /* 排序条件:使用的列名  */
    private String sortColumns;
    
<#-- #############################################    get/set方法部分       ############################################# -->
  <#list columnList as column>
      <#if column.javaType == "Date" || column.javaType == "Double" || column.javaType == "Integer">
    public ${column.javaType} get${column.propertyName?cap_first}Start(){
        return ${column.propertyName}Start;
    }

    public void set${column.propertyName?cap_first}Start(${column.javaType} ${column.propertyName}Start){
        this.${column.propertyName}Start = ${column.propertyName}Start;
    }

    public ${column.javaType} get${column.propertyName?cap_first}End(){
        return ${column.propertyName}End;
    }

    public void set${column.propertyName?cap_first}End(${column.javaType} ${column.propertyName}End){
        this.${column.propertyName}End = ${column.propertyName}End;
    }
      </#if>
  </#list>
  	public String getSortColumns() {
		return sortColumns;
	}

	public void setSortColumns(String sortColumns) {
		this.sortColumns = sortColumns;
	}
  <#-- #############################################    ToString部分       ############################################# -->

	@Override
    public String toString() {
    	String lineSeparator = System.getProperty("line.separator");
    	String separator = "," + lineSeparator;
        StringBuffer str = new StringBuffer();
        str.append(getClass().getName()).append("@").append(hashCode()).append("{").append(lineSeparator);
  <#list columnList as column>
	<#if column.javaType == "Date" || column.javaType == "Double" || column.javaType == "Integer">
		str.append("    ${column.propertyName}Start=").append(get${column.propertyName?cap_first}Start()).append(separator);
		str.append("    ${column.propertyName}=").append(get${column.propertyName?cap_first}()).append(separator);
		str.append("    ${column.propertyName}End=").append(get${column.propertyName?cap_first}End()).append(separator);
	<#else>
		str.append("    ${column.propertyName}=").append(get${column.propertyName?cap_first}()).append(separator);
	</#if>
  </#list>
		str.append("    sortColumns=").append(getSortColumns()).append(lineSeparator);
        str.append("}").append(lineSeparator);
        return str.toString();
    }
}

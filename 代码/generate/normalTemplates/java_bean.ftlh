package ${basePachage}.domain.${partCode};

import java.io.Serializable;
<#-- #############################################    根据字段类型，导入特殊的包       ############################################# -->
  <#list columnList as column>
      <#if column.javaType == "Date">
import java.util.Date;
           <#break>
      </#if>
  </#list>

/**
 * <pre>
 * <b>类描述:</b>${beanName}表的对应的java对象，该文件为工具自动生成
 * <b>作者:</b>zhanglei29
 * <b>创建日期:</b>${dateStr}
 * </pre>
 */
public class ${beanName} implements Serializable{

    private static final long serialVersionUID = 1L;
    
<#-- #############################################    变量定义部分       ############################################# -->
  <#list columnList as column>
    /** 
     * ${column.columnName} 
     * 数据库字段: ${column.columnCode}
     */
    private ${column.javaType} ${column.propertyName};
  </#list>
<#-- #############################################    get/set方法部分       ############################################# -->
  <#list columnList as column>

    public ${column.javaType} get${column.propertyName?cap_first}(){
        return ${column.propertyName};
    }
    public void set${column.propertyName?cap_first}(${column.javaType} ${column.propertyName}){
        this.${column.propertyName} = ${column.propertyName};
    }
  </#list>
<#-- #############################################    ToString部分       ############################################# -->

	@Override
    public String toString() {
    	String lineSeparator = System.getProperty("line.separator");
    	String separator = "," + lineSeparator;
        StringBuffer str = new StringBuffer();
        str.append(getClass().getName()).append("@").append(hashCode()).append("{").append(lineSeparator);
  <#list columnList as column>
	<#if column_index+1 == columnList?size>
        str.append("    ${column.propertyName}=").append(get${column.propertyName?cap_first}()).append(lineSeparator);
    <#else>
        str.append("    ${column.propertyName}=").append(get${column.propertyName?cap_first}()).append(separator);
    </#if>
  </#list>
        str.append("}").append(lineSeparator);
        return str.toString();
    }
}

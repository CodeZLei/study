package com.le.code.utils;

import java.util.Map;
import java.util.Set;

public class KcoderUtils {
	/**
	 * 根据表明获取模块汉语
	 * 
	 * @param tableName
	 * @return
	 */
	public static String getPartCode(String tableName) {
		return tableName.split("_")[0];
	}

	/**
	 * 根据表名（xxx_yyy_zzz）得到javaBean的名字(XxxYyyZzz)-首字母大写
	 * 
	 * @param tableName
	 * @return
	 */
	public static String getBeanName(String tableName) {
		String javaName = dbStr2Java(tableName);
		return javaName.substring(0, 1).toUpperCase() + javaName.substring(1);
	}

	/**
	 * 根据表字段名（xxx_yyy_zzz）得到javaBean的属性的名字(xxxYyyZzz)-首字母小写
	 * 
	 * @param columnName
	 * @return
	 */
	public static String getPropertyName(String columnName) {
		return dbStr2Java(columnName);
	}
	
	/**
	 * 数据库字段类型转换成java字段类型
	 * 
	 * @param columnDataType
	 * @return
	 */
	public static String getJavaType(String columnDataType) {
		return ConfigConstants.javaTypeMap.get(columnDataType.replaceAll("\\(.*?\\)|(.*?)", "").toLowerCase());
	} 
	
	/**
	 * 数据库字段类型转换成JDBC字段类型
	 * 
	 * @param columnDataType
	 * @return
	 */
	public static String getJdbcType(String columnDataType) {
		return ConfigConstants.jdbcTypeMap.get(columnDataType.replaceAll("\\(.*?\\)|(.*?)", "").toLowerCase());
	}

	/**
	 * 根据数据库的表名或字段名（例如：xx_yy_zz）获取java的名字(xxYyZz)
	 * 
	 * @param dbStr
	 * @return
	 */
	private static String dbStr2Java(String dbStr) {
		StringBuffer sb = new StringBuffer(dbStr.length());
		String[] fields = dbStr.toLowerCase().split("_");
		String temp = null;
		sb.append(fields[0]);
		for (int i = 1, len = fields.length; i < len; i++) {
			temp = fields[i].trim();
			if(null == temp||temp.equals("")){
				continue;
			}
			sb.append(temp.substring(0, 1).toUpperCase()).append(temp.substring(1));
		}
		return sb.toString();
	}
	
	/**
	 * 获取字段长度
	 * 
	 * @param type
	 * @return
	 */
	public static int getTypeLength(String type) {
		int len = 0;
		try {
			if (type.indexOf("(") > 0 && type.indexOf(")") > 1) {
				String lenStr = type.substring(type.indexOf("(") + 1, type.lastIndexOf(")"));
				len = Integer.valueOf(lenStr);
			}
		} catch (Exception e) {
			len = 0;
		}
		return len;
	}
}

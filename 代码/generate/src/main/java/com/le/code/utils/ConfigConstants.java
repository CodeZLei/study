package com.le.code.utils;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class ConfigConstants {
	/** jdbcType映射关系 **/
	public static Map<String, String> jdbcTypeMap;
	/** javaType映射关系 **/
	public static Map<String, String> javaTypeMap;

	static {
		// 加载jdbcType和javaType的映射关系
		jdbcTypeMap = new HashMap<String, String>();
		javaTypeMap = new HashMap<String, String>();
		String propertyTypeMapping = PropertiesUtils.getString("mapping.propery.type");
		JSONArray propertyTypeJson = JSON.parseArray(propertyTypeMapping);
		for (Object obj : propertyTypeJson) {
			JSONObject jsonObj = JSON.parseObject(obj.toString());
			jdbcTypeMap.put(jsonObj.getString("sqltype").toLowerCase(), jsonObj.getString("jdbctype"));
			javaTypeMap.put(jsonObj.getString("sqltype").toLowerCase(), jsonObj.getString("javatype"));
		}
	}
}

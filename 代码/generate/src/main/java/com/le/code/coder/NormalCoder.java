package com.le.code.coder;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.le.code.bean.Table;
import com.le.code.parser.BaseParser;
import com.le.code.utils.FileUtils;
import com.le.code.utils.KcoderUtils;
import com.le.code.utils.PropertiesUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

/**
 * 普通代码生成
 * 
 * @author Administrator
 *
 */
public class NormalCoder {
	/** 项目名字 */
	private String projectName;
	private String baseSrcPath;
	/** # 普通模板文件路径*/
	private String templateFilePath;
	private String desFilePath;
	private String dateStr;
	/** freemarker 的配置 **/
	private Configuration cfg;
	/** 项目的基础包结构 **/
	private String basePachage;
	/** 模板文件的生成目录 **/
	private Map<String, String> templateFilePathMap;
	/** 模板文件的生成方式 **/
	private Map<String, String> templateFileTypeMap;
	/** 数据集合 **/
	private List<Map<String, Object>> dataList;

	private StringBuilder warnMsg;

	public void action(BaseParser parser) throws Exception {
		// 初始化检查
		check();
		// 初始化操作
		init(parser);
		// 开始生成
		scanAndGenerate(templateFilePath);
		// 打印结果
		printResult();
	}

	/**
	 * 生成代码前检查
	 */
	private void check() {
		// TODO：有待完善
	}

	/**
	 * 完成初始化操作：加载文件路径信息；时间； 初始化dataList；读取模板配置；初始化freemarker
	 * 
	 * @throws Exception
	 */
	private void init(BaseParser parser) throws Exception {
		System.out.println("初始化...");
		warnMsg = new StringBuilder();

		// 加载并检查文件路径
		templateFilePath = PropertiesUtils.getString("path.normalTemplate");
		basePachage = PropertiesUtils.getString("bathPackage.normalTemplate");
		desFilePath = PropertiesUtils.getString("path.destFile");
		projectName = PropertiesUtils.getString("projectName.normalTemplate");
		baseSrcPath = basePachage.replaceAll("\\.", "/");
		if (!new File(templateFilePath).isDirectory()) { // 模板目录检查
			throw new Exception("模板文件所在目录[" + templateFilePath + "]不存在或不是目录！");
		}
		FileUtils.deleteAllFilesOfDir(desFilePath);// 清空目标文件路径

		// 时间
		dateStr = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());

		// 初始化dataList
		dataList = new ArrayList<Map<String, Object>>();
		List<Table> tableList = parser.parse();
		for (Table table : tableList) {
			dataList.add(getDataMap(table));
		}

		// 读取模板配置
		templateFilePathMap = new HashMap<String, String>();
		templateFileTypeMap = new HashMap<String, String>();
		String templateMapping = PropertiesUtils.getString("mapper.normalTemplate");
		JSONArray templateJson = JSON.parseArray(templateMapping);
		for (Object obj : templateJson) {
			JSONObject jsonObj = JSON.parseObject(obj.toString());
			templateFilePathMap.put(jsonObj.getString("templateFileName"), jsonObj.getString("desFileName"));
			templateFileTypeMap.put(jsonObj.getString("templateFileName"), jsonObj.getString("fileType"));
		}

		// 初始化freemarker
		cfg = new Configuration(Configuration.VERSION_2_3_25);
		cfg.setDirectoryForTemplateLoading(new File(templateFilePath));
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		cfg.setLogTemplateExceptions(false);

	}

	/**
	 * 递归遍历指定目录，生成目标文件
	 * 
	 * @param path
	 * @throws Exception
	 */
	private void scanAndGenerate(String location) throws Exception {
		File srcFile = new File(location);
		if (srcFile.isDirectory()) {
			System.out.println("遍历目录:" + location);
			File[] files = srcFile.listFiles();
			for (File file : files) {
				scanAndGenerate(file.getPath());
			}
		} else {
			System.out.println("模板文件：" + location);
			generate(srcFile);
		}
	}

	/**
	 * 遍历dataList 生成文件
	 * 
	 * @param templateFileName
	 * @throws Exception
	 */
	private void generate(File srcFile) throws Exception {
		// 得到目标文件路径
		String templateFileName = srcFile.getName();
		String desFileName = templateFilePathMap.get(templateFileName);
		if (null == desFileName || "".equals(desFileName)) {
			warnMsg.append("[" + srcFile.getParent() + File.separator + srcFile.getName() + "]");
			return;
		}
		// 遍历dataList，生成代码
		for (Map<String, Object> dataMap : dataList) {
			String desFileNameTmp1 = desFileName.replaceAll("@BeanName@", dataMap.get("beanName").toString());
			String desFileNameTmp2 = desFileNameTmp1.replaceAll("@PartCode@", dataMap.get("partCode").toString());
			String desFileNameTmp3 = desFileNameTmp2.replaceAll("@projectName@", dataMap.get("projectName").toString());
			String desFileNameTmp4 = desFileNameTmp3.replaceAll("@baseSrcPath@", dataMap.get("baseSrcPath").toString());
			String destFilePath = desFilePath + File.separator + desFileNameTmp4;

			// 如果目标文件所属目录不存在，则先创建目录
			File destFile = new File(destFilePath);
			if (!destFile.getParentFile().exists()) {
				destFile.getParentFile().mkdirs();
			}

			// 生成
			Template temp = cfg.getTemplate(templateFileName);
			FileWriter fw;
			if ("new".equalsIgnoreCase(templateFileTypeMap.get(templateFileName))) {
				fw = new FileWriter(destFile);
			} else {
				fw = new FileWriter(destFile, true);
			}
			temp.process(dataMap, fw);
			fw.flush();
			fw.close();
		}
	}

	/**
	 * 组织freemarker所需模板数据
	 * 
	 * @param table
	 * @return
	 */
	private Map<String, Object> getDataMap(Table table) {
		String beanName = KcoderUtils.getBeanName(table.getTableCode());
		String tableName = table.getTableCode();
		String tableComment = table.getTableComment();
		String havePk = table.getPrimaryKeys().size() > 0 ? "true" : "false";
		String firstKey = table.getPrimaryKeys().size() > 0 ? table.getPrimaryKeys().get(0).getPropertyName() : "";
		// 组织数据
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("projectName", projectName);
		dataMap.put("baseSrcPath", baseSrcPath);
		dataMap.put("basePachage", basePachage);
		dataMap.put("partCode", KcoderUtils.getPartCode(table.getTableCode()));
		dataMap.put("partName", KcoderUtils.getPartCode(table.getTableCode()));
		dataMap.put("dateStr", dateStr);
		dataMap.put("beanName", beanName);
		dataMap.put("tableName", tableName);
		dataMap.put("tableComment", tableComment);
		dataMap.put("havePk", havePk);
		dataMap.put("firstKey", firstKey);
		dataMap.put("columnList", table.getColumns());
		dataMap.put("keyColumnList", table.getPrimaryKeys());
		return dataMap;
	}

	/**
	 * 打印生成结果
	 */
	private void printResult() {
		if (warnMsg.length() < 1) {
			System.out.println("生成成功！");
		} else {
			System.out.println("生成成功，注意：" + warnMsg.toString() + "由于没有找到配置信息，所以没有生成代码！");
		}
	}
}

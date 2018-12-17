package com.le.code.utils;

import java.io.File;

/**
 * 文件工具类
 * 
 * @author Administrator
 *
 */
public class FileUtils {
	/**
	 * 删除文件或目录
	 * 
	 * @param filePath
	 */
	public static void deleteAllFilesOfDir(String filePath) {
		// 如果filePath不以文件分隔符结尾，自动添加文件分隔符
		if (!filePath.endsWith(File.separator)) {
			filePath = filePath + File.separator;
		}
		File dirFile = new File(filePath);
		deleteAllFilesOfDir(dirFile);
	}

	/**
	 * 删除文件或目录
	 * 
	 * @param file
	 */
	private static void deleteAllFilesOfDir(File file) {
		if (!file.exists())
			return;
		if (file.isFile()) {
			file.delete();
			return;
		}
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			deleteAllFilesOfDir(files[i]);
		}
		file.delete();
	}
}

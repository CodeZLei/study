package com.le.code.parser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.le.code.bean.Column;
import com.le.code.bean.Table;
import com.le.code.utils.KcoderUtils;
import com.le.code.utils.PropertiesUtils;

/**
 * 
 * @author Administrator
 *
 */
public class MysqlParser extends BaseParser {

	/** 数据库连接 **/
	private Connection conn = null;

	/** 显示所有表信息 **/
	private static final String SQL_SHOW_TABLE_STATUS = "show table status";
	/** 查询表字段 **/
	private static final String SQL_PREFIX_SHOW_FIELDS = "show full fields from ";
	private static final String NULLABLE_YES = "YES";
	private static final String NULLABLE_NO = "NO";
	private static final String KEY_PRIMARY = "PRI";

	/**
	 * 用于初始化数据库连接和配置信息
	 */
	private void init() throws Exception {
		// 加载数据库连接
		String driverName = PropertiesUtils.getString("db.driver.name");
		String url = PropertiesUtils.getString("db.url");
		String user = PropertiesUtils.getString("db.username");
		String password = PropertiesUtils.getString("db.password");
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 读取数据信息
	 * 
	 * @return
	 */
	@Override
	public List<Table> parse() throws Exception {
		// 初始化工作
		init();

		List<Table> tableList = new ArrayList<Table>();
		PreparedStatement pstate = null;
		ResultSet results = null;
		ResultSet clumnResult = null;
		try {
			pstate = conn.prepareStatement(SQL_SHOW_TABLE_STATUS);
			results = pstate.executeQuery();
			if(null == results || results.wasNull()){
				throw new Exception("数据库中没有表，请检查！");
			}
			// 获取表信息
			while (results.next()) {
				String tableName = results.getString("NAME");
				String comment = results.getString("COMMENT");

				ArrayList<Column> columnList = new ArrayList<Column>();
				ArrayList<Column> keyColumnList = new ArrayList<Column>();

				Table info = new Table();
				info.setTableCode(tableName);
				info.setTableComment(comment);
				info.setColumns(columnList);
				info.setPrimaryKeys(keyColumnList);
				tableList.add(info);
				// 获取字段信息
				pstate = conn.prepareStatement(SQL_PREFIX_SHOW_FIELDS + tableName);
				clumnResult = pstate.executeQuery();
				while (clumnResult.next()) {
					Column BaseColumn = new Column();
					BaseColumn.setColumnCode(clumnResult.getString("FIELD"));
					BaseColumn.setPropertyName(KcoderUtils.getPropertyName(clumnResult.getString("FIELD")));
					BaseColumn.setColumnDataType(clumnResult.getString("TYPE"));
					BaseColumn.setJavaType(KcoderUtils.getJavaType(clumnResult.getString("TYPE")));
					BaseColumn.setJdbcType(KcoderUtils.getJdbcType(clumnResult.getString("TYPE")));
					BaseColumn.setColumnName(clumnResult.getString("COMMENT"));
					BaseColumn.setLength(KcoderUtils.getTypeLength(clumnResult.getString("TYPE")));
					// 字段是否为空
					if (NULLABLE_YES.equalsIgnoreCase(clumnResult.getString("NULL"))) {
						BaseColumn.setIsNullable(true);
					} else if (NULLABLE_NO.equalsIgnoreCase(clumnResult.getString("NULL"))) {
						BaseColumn.setIsNullable(false);
					}
					// 判断是否是PRIMARY Key
					if (KEY_PRIMARY.equals(clumnResult.getString("Key"))) {
						BaseColumn.setIsPrimaryKey(true);
					} else {
						BaseColumn.setIsPrimaryKey(false);
					}
					if (BaseColumn.getIsPrimaryKey()) {
						keyColumnList.add(BaseColumn);
					}
					columnList.add(BaseColumn);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != clumnResult) {
				try {
					clumnResult.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != results) {
				try {
					results.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return tableList;
	}
}

package com.le.code.parser;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.le.code.bean.Column;
import com.le.code.bean.Table;
import com.le.code.utils.KcoderUtils;
import com.le.code.utils.PropertiesUtils;

public class PdmFileParser extends BaseParser {
	
	public static void main(String[] args) throws Exception {
		List<Table> tableList = new PdmFileParser().parse();
		System.out.println(tableList.size());
	}

	@Override
	public List<Table> parse() throws Exception {
		String pdmFilePath = PropertiesUtils.getString("path.pdmFile");
		SAXReader sax = new SAXReader();
		Document doc = sax.read(pdmFilePath);
		Node modelNode = doc.selectSingleNode("//c:Children/o:Model");
		return parseTable(modelNode);
	}

	private ArrayList<Table> parseTable(Node node) throws Exception {
		ArrayList<Table> tableList = new ArrayList<Table>();
		for (Object tableObj : node.selectNodes("c:Tables/o:Table")) {
			Node tableNode = (Node) tableObj;
			Table table = new Table();
			table.setTableId(((Element) tableNode).attributeValue("Id"));
			table.setTableCode(tableNode.selectSingleNode("a:Code").getText());
			table.setTableName(tableNode.selectSingleNode("a:Name").getText());
			table.setTableComment(tableNode.selectSingleNode("a:Comment") == null ? "" : tableNode.selectSingleNode("a:Comment").getText());
			table.setColumns(parseColumn(tableNode));
			// 添加PrimaryKey
			if (null == tableNode.selectSingleNode("c:PrimaryKey/o:Key")) {
				System.out.println(table.getTableCode() + "没有主键！");
			} else {
				String primaryKeyId = ((Element) tableNode.selectSingleNode("c:PrimaryKey/o:Key")).attributeValue("Ref");
				table.setPrimaryKeys(parsePrimaryKey(table, tableNode, primaryKeyId));
			}

			tableList.add(table);
		}
		return tableList;
	}

	private ArrayList<Column> parseColumn(Node node) {
		ArrayList<Column> columnList = new ArrayList<Column>();
		for (Object columnObj : node.selectNodes("c:Columns/o:Column")) {
			Node columnNode = (Node) columnObj;
			Column column = new Column();
			// 从Pdm文件直接解析
			column.setColumnId(((Element) columnNode).attributeValue("Id"));
			column.setColumnName(columnNode.selectSingleNode("a:Name").getText());
			column.setColumnCode(columnNode.selectSingleNode("a:Code").getText());
			column.setColumnDataType(columnNode.selectSingleNode("a:DataType").getText().replaceAll("\n", "").replaceAll(" ", "")); // 防止换行导致问题
			column.setColumnComment(selectSingleNodeStringText(columnNode, "a:Comment"));
			column.setLength(selectSingleNodeIntText(columnNode, "a:Length"));
			column.setPrecision(selectSingleNodeIntText(columnNode, "a:Precision"));
			int mandatory = selectSingleNodeIntText(columnNode, "a:Mandatory");
			column.setIsNullable(mandatory > 0 ? false : true);
			// 额外
			if (null == KcoderUtils.getJavaType(column.getColumnDataType())) {
				System.out.println(node.selectSingleNode("a:Code").getText()+"-"+column.getColumnCode()+"-"+column.getColumnDataType() + "没有映射关系");
			}
			column.setPropertyName(KcoderUtils.getPropertyName(column.getColumnCode()));
			column.setJavaType(KcoderUtils.getJavaType(column.getColumnDataType()));
			column.setJdbcType(KcoderUtils.getJdbcType(column.getColumnDataType()));
			columnList.add(column);
		}
		return columnList;
	}

	private ArrayList<Column> parsePrimaryKey(Table table, Node node, String primaryKeyId) throws Exception {
		if (null == table) {
			throw new Exception("读取主键信息失败：传入的Table为空！");
		}
		ArrayList<Column> keyList = new ArrayList<Column>();
		for (Object keyObj : node.selectNodes("c:Keys/o:Key")) {
			Node keyNode = (Node) keyObj;
			String keyId = ((Element) keyNode).attributeValue("Id");
			if (!primaryKeyId.equals(keyId)) {
				continue;
			}
			for (Object column : keyNode.selectNodes("c:Key.Columns/o:Column")) {
				String id = ((Element) column).attributeValue("Ref");
				table.getColumn(id).setIsPrimaryKey(true);
				keyList.add(table.getColumn(id));
			}
		}
		return keyList;
	}

	private int selectSingleNodeIntText(Node parentNode, String childNodeName) {
		Node childNode = parentNode.selectSingleNode(childNodeName);
		if (childNode != null) {
			return Integer.parseInt(childNode.getText());
		} else {
			return 0;
		}
	}

	private String selectSingleNodeStringText(Node parentNode, String childNodeName) {
		Node childNode = parentNode.selectSingleNode(childNodeName);
		if (childNode != null) {
			return childNode.getText();
		} else {
			return null;
		}
	}
}

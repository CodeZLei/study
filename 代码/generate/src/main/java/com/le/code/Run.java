package com.le.code;

import com.le.code.coder.NormalCoder;
import com.le.code.parser.BaseParser;
import com.le.code.parser.MysqlParser;
import com.le.code.parser.PdmFileParser;

public class Run {
	public static void main(String[] args) throws Exception {
		BaseParser parser = new MysqlParser();
		//BaseParser parser = new PdmFileParser();
		new NormalCoder().action(parser);
	}
}

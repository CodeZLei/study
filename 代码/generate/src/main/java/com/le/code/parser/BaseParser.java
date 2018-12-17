package com.le.code.parser;

import java.util.List;

import com.le.code.bean.Table;

public abstract class BaseParser {
	abstract public List<Table> parse() throws Exception;
}

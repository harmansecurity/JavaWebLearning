package com.ecnu.DB;

import java.util.LinkedHashMap;
import java.util.Map;

import com.ecnu.domain.Book;
//代表数据库
public class DB {
	private static Map map = new LinkedHashMap();
	//静态代码块只使用一次
	static{
		map.put("1", new Book("1","java开发","老张",38,"一本好书"));
		map.put("2", new Book("2","C开发","老王",25,"一本好书"));
		map.put("3", new Book("3","mysql开发","老李",18,"一本好书"));
		map.put("4", new Book("4","web开发","老方",48,"一本好书"));
		map.put("5", new Book("5","数据库开发","老小",22,"一本好书"));
		map.put("6", new Book("6","安全开发","老刚",39,"一本好书"));
	}
	
	public static Map getAll(){
		return map;
	}
}

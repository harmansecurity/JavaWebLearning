package com.ecnu.DB;

import java.util.LinkedHashMap;
import java.util.Map;

import com.ecnu.domain.Book;
//�������ݿ�
public class DB {
	private static Map map = new LinkedHashMap();
	//��̬�����ֻʹ��һ��
	static{
		map.put("1", new Book("1","java����","����",38,"һ������"));
		map.put("2", new Book("2","C����","����",25,"һ������"));
		map.put("3", new Book("3","mysql����","����",18,"һ������"));
		map.put("4", new Book("4","web����","�Ϸ�",48,"һ������"));
		map.put("5", new Book("5","���ݿ⿪��","��С",22,"һ������"));
		map.put("6", new Book("6","��ȫ����","�ϸ�",39,"һ������"));
	}
	
	public static Map getAll(){
		return map;
	}
}

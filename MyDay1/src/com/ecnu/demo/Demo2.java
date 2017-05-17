package com.ecnu.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.junit.Test;

public class Demo2 {

	/**
	 * 增强for
	 */
	@Test
	public void test1(){
		int arr[]={1,2,3};
		for(int num : arr){
			System.out.println(num);
		}
	}
	
	@Test
	public void test2(){
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		
		for(Object object : list){
			int i=(Integer)object;
			System.out.println(i);
		}
	}
	
	/**
	 * 先去除Key值再取出Value值
	 */
	@Test
	public void test3(){
		Map<String, String>map=new HashMap<String, String>();//HashMap去除重复且无序，LinkedHashMap去除重复有序
		map.put("111", "aaa");
		map.put("111", "aaa");
		map.put("333", "aaa");
		map.put("444", "aaa");
		
		Set<String>set=map.keySet();
		Iterator<String>it =set.iterator();
		while(it.hasNext()){
			String key=it.next();
			String value=map.get(key);
			System.out.println(key+"="+value);
		}
	}

	/**
	 * 直接取出entry,包含key和value
	 */
	@Test
	public void test4(){
		Map<String, String>map=new LinkedHashMap<String, String>();//HashMap去除重复且无序，LinkedHashMap去除重复有序
		map.put("111", "aaa");
		map.put("111", "aaa");
		map.put("333", "aaa");
		map.put("444", "aaa");
		
		Set set=map.entrySet();
		Iterator it =set.iterator();
		while(it.hasNext()){
			Map.Entry<String, String>entry=(Entry)it.next();
			System.out.println(entry.getKey()+"="+entry.getValue());
		}
	}
	
	/**
	 * 增強for取map的第一種方法
	 */
	@Test
	public void test5(){
		Map<String, String>map=new LinkedHashMap<String, String>();//HashMap去除重复且无序，LinkedHashMap去除重复有序
		map.put("111", "aaa");
		map.put("111", "aaa");
		map.put("333", "aaa");
		map.put("444", "aaa");
		
		for(Object obj : map.keySet()){
			String key=(String)obj;
			String value=(String)map.get(key);
			System.out.println(key+"="+value);	
		}
	}
	
	/**
	 * 增強for取map的第二種方法
	 */
	@Test
	public void test6(){
		Map<String, String>map=new LinkedHashMap<String, String>();//HashMap去除重复且无序，LinkedHashMap去除重复有序
		map.put("111", "aaa");
		map.put("111", "aaa");
		map.put("333", "aaa");
		map.put("444", "aaa");
		
		for(Object obj : map.entrySet()){
			Map.Entry<String, String> entry=(Entry)obj;
			System.out.println(entry.getKey()+"="+entry.getValue());	
		}
	}
	
	/**
	 * 使用增強for需要注意的问题:增强for只适合取数据
	 */
	@Test
	public void test7(){
		List list = new ArrayList();
		list.add(1);
		for(Object obj : list){
			obj=10;
		}
		System.out.println(list.get(0));
	}
}

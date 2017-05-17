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
	 * ��ǿfor
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
	 * ��ȥ��Keyֵ��ȡ��Valueֵ
	 */
	@Test
	public void test3(){
		Map<String, String>map=new HashMap<String, String>();//HashMapȥ���ظ�������LinkedHashMapȥ���ظ�����
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
	 * ֱ��ȡ��entry,����key��value
	 */
	@Test
	public void test4(){
		Map<String, String>map=new LinkedHashMap<String, String>();//HashMapȥ���ظ�������LinkedHashMapȥ���ظ�����
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
	 * ����forȡmap�ĵ�һ�N����
	 */
	@Test
	public void test5(){
		Map<String, String>map=new LinkedHashMap<String, String>();//HashMapȥ���ظ�������LinkedHashMapȥ���ظ�����
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
	 * ����forȡmap�ĵڶ��N����
	 */
	@Test
	public void test6(){
		Map<String, String>map=new LinkedHashMap<String, String>();//HashMapȥ���ظ�������LinkedHashMapȥ���ظ�����
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
	 * ʹ������for��Ҫע�������:��ǿforֻ�ʺ�ȡ����
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

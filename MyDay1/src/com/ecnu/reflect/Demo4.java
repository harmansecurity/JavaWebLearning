package com.ecnu.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

public class Demo4 {

	// ������ĳ�Ա����public String name = "tewrtwe";
	@Test
	public void test1() throws Exception {
		Person p = new Person();
		Class classzz = Class.forName("com.ecnu.reflect.Person");
		Field f = classzz.getField("name");
		//��ȡ�ֶε�����
		Class type = f.getType();
		System.out.println(type);
		String name=(String)f.get(p);
		System.out.println(name);
		
		//�����ֶε�ֵ
		f.set(p, "xxxxxxx");
		System.out.println(p.name);
	}
	
	// ������ĳ�Ա����private int password=4312;
	@Test
	public void test2() throws Exception {
		Person p = new Person();
		Class classzz = Class.forName("com.ecnu.reflect.Person");
		Field f = classzz.getDeclaredField("password");
		f.setAccessible(true);
		System.out.println(f.get(p));
	}
	
	// ������ĳ�Ա����private static int age=45;
	@Test
	public void test3() throws Exception {
		Person p = new Person();
		Class classzz = Class.forName("com.ecnu.reflect.Person");
		Field f = classzz.getDeclaredField("age");
		f.setAccessible(true);
		System.out.println(f.get(p));
	}
}

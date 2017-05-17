package com.ecnu.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

public class Demo4 {

	// 反射类的成员变量public String name = "tewrtwe";
	@Test
	public void test1() throws Exception {
		Person p = new Person();
		Class classzz = Class.forName("com.ecnu.reflect.Person");
		Field f = classzz.getField("name");
		//获取字段的类型
		Class type = f.getType();
		System.out.println(type);
		String name=(String)f.get(p);
		System.out.println(name);
		
		//设置字段的值
		f.set(p, "xxxxxxx");
		System.out.println(p.name);
	}
	
	// 反射类的成员变量private int password=4312;
	@Test
	public void test2() throws Exception {
		Person p = new Person();
		Class classzz = Class.forName("com.ecnu.reflect.Person");
		Field f = classzz.getDeclaredField("password");
		f.setAccessible(true);
		System.out.println(f.get(p));
	}
	
	// 反射类的成员变量private static int age=45;
	@Test
	public void test3() throws Exception {
		Person p = new Person();
		Class classzz = Class.forName("com.ecnu.reflect.Person");
		Field f = classzz.getDeclaredField("age");
		f.setAccessible(true);
		System.out.println(f.get(p));
	}
}

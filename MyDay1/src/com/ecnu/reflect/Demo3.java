package com.ecnu.reflect;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;

import org.junit.Test;

//反射类的方法
public class Demo3 {

	// 反射类的方法 public void aa1(){}
	@Test
	public void test1() throws Exception {
		Person p = new Person();
		Class classzz = Class.forName("com.ecnu.reflect.Person");
		Method method = classzz.getMethod("aa1", null);
		method.invoke(p, null);// 传参数
	}

	// 反射类的方法 public void aa1(String name,int password){}
	@Test
	public void test2() throws Exception {
		Person p = new Person();
		Class classzz = Class.forName("com.ecnu.reflect.Person");
		Method method = classzz.getMethod("aa1", String.class, int.class);
		method.invoke(p, "zxx", 38);// 传参数
	}

	// 反射类的方法 public Class [] aa1(String name,int[]password)
	@Test
	public void test3() throws Exception {
		Person p = new Person();
		Class classzz = Class.forName("com.ecnu.reflect.Person");
		Method method = classzz.getMethod("aa1", String.class, int[].class);
		Class cs[] = (Class[]) method.invoke(p, "zxx", new int[] { 1, 2, 3 });// 传参数
		System.out.println(cs[0]);
	}

	// 反射类的方法 private void aa1(InputStream in)
	@Test
	public void test4() throws Exception {
		Person p = new Person();
		Class classzz = Class.forName("com.ecnu.reflect.Person");
		Method method = classzz.getDeclaredMethod("aa1", InputStream.class);
		method.setAccessible(true);
		method.invoke(p, new FileInputStream("c:\\2.txt"));// 传参数
	}

	// 反射类的方法public static void aa1(int num)
	@Test
	public void test5() throws Exception {
		// Person p= new Person();
		Class classzz = Class.forName("com.ecnu.reflect.Person");
		Method method = classzz.getMethod("aa1", int.class);
		method.invoke(null, 23);// 静态方法可以不传对象
	}
	
	// 反射类的方法public static void main(String[] args)
	@Test
	public void test6() throws Exception {
		// Person p= new Person();
		Class classzz = Class.forName("com.ecnu.reflect.Person");
		Method method = classzz.getMethod("main", String[].class);
		method.invoke(null, (Object)new String[]{"4234","423"});
	}
}

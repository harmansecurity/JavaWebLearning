package com.ecnu.reflect;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.sun.xml.internal.bind.v2.runtime.Name;


//反射类的构造函数，创建类的对象
public class Demo2 {
	
	//反射构造函数 person(){}
	@Test
	public void test1() throws Exception{
		Class classzz = Class.forName("com.ecnu.reflect.Person");
		Constructor c=classzz.getConstructor(null);
		Person p=(Person)c.newInstance(null);//用反射创建对象，主要用于框架里面
		
		System.out.println(p.name);
	}
	
	//反射构造函数 person(String name){}
	@Test
	public void test2() throws Exception{
		Class classzz = Class.forName("com.ecnu.reflect.Person");
		Constructor c=classzz.getConstructor(String.class);
		Person p=(Person)c.newInstance("xxxxxxxxx");//用反射创建对象，主要用于框架里面
		
		System.out.println(p.name);
	}
	
	//反射构造函数 person(String name,int password){}
	@Test
	public void test3() throws Exception{
		Class classzz = Class.forName("com.ecnu.reflect.Person");
		Constructor c=classzz.getConstructor(String.class,int.class);
		Person p=(Person)c.newInstance("nihaoa",55);//用反射创建对象，主要用于框架里面
		
		System.out.println(p.name);
	}
	
	//反射构造函数private Person(List list){}
	@Test
	public void test4() throws Exception{
		Class classzz = Class.forName("com.ecnu.reflect.Person");
		Constructor c=classzz.getDeclaredConstructor(List.class);
		c.setAccessible(true);//私有的使用暴力反射就可以访问
		Person p=(Person)c.newInstance(new ArrayList());//用反射创建对象，主要用于框架里面
		
		System.out.println(p.name);
	}
	
	//创建对象的另外一种途径，一下代码等效于test1
	@Test
	public void test5() throws Exception{
		Class classzz = Class.forName("com.ecnu.reflect.Person");
		Person p=(Person)classzz.newInstance();//默认无参的
		System.out.println(p.name);
	}
	
	
	 
	
}

package com.ecnu.reflect;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.sun.xml.internal.bind.v2.runtime.Name;


//������Ĺ��캯����������Ķ���
public class Demo2 {
	
	//���乹�캯�� person(){}
	@Test
	public void test1() throws Exception{
		Class classzz = Class.forName("com.ecnu.reflect.Person");
		Constructor c=classzz.getConstructor(null);
		Person p=(Person)c.newInstance(null);//�÷��䴴��������Ҫ���ڿ������
		
		System.out.println(p.name);
	}
	
	//���乹�캯�� person(String name){}
	@Test
	public void test2() throws Exception{
		Class classzz = Class.forName("com.ecnu.reflect.Person");
		Constructor c=classzz.getConstructor(String.class);
		Person p=(Person)c.newInstance("xxxxxxxxx");//�÷��䴴��������Ҫ���ڿ������
		
		System.out.println(p.name);
	}
	
	//���乹�캯�� person(String name,int password){}
	@Test
	public void test3() throws Exception{
		Class classzz = Class.forName("com.ecnu.reflect.Person");
		Constructor c=classzz.getConstructor(String.class,int.class);
		Person p=(Person)c.newInstance("nihaoa",55);//�÷��䴴��������Ҫ���ڿ������
		
		System.out.println(p.name);
	}
	
	//���乹�캯��private Person(List list){}
	@Test
	public void test4() throws Exception{
		Class classzz = Class.forName("com.ecnu.reflect.Person");
		Constructor c=classzz.getDeclaredConstructor(List.class);
		c.setAccessible(true);//˽�е�ʹ�ñ�������Ϳ��Է���
		Person p=(Person)c.newInstance(new ArrayList());//�÷��䴴��������Ҫ���ڿ������
		
		System.out.println(p.name);
	}
	
	//�������������һ��;����һ�´����Ч��test1
	@Test
	public void test5() throws Exception{
		Class classzz = Class.forName("com.ecnu.reflect.Person");
		Person p=(Person)classzz.newInstance();//Ĭ���޲ε�
		System.out.println(p.name);
	}
	
	
	 
	
}

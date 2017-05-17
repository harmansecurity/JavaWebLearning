package com.ecnu.introspector;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.junit.Test;


//使用内省api操作bean的属性
public class Demo1 {
	//得到bean的所有属性
	@Test
	public void test1() throws Exception{
		//BeanInfo info = Introspector.getBeanInfo(Person.class); //包含class属性
		BeanInfo info = Introspector.getBeanInfo(Person.class,Object.class);//bean自己的属性
		PropertyDescriptor[] pds=info.getPropertyDescriptors();//拿到属性描述器
		for(PropertyDescriptor pd : pds){
			System.out.println(pd.getName());
		}
	}
	
	//操作bean的指定属性
	@Test
	public void test2() throws Exception{
		Person p =new Person();
		PropertyDescriptor pd =new PropertyDescriptor("age", Person.class);
		
		//得到属性的写方法，为属性赋值
		Method method=pd.getWriteMethod();//public void setAge(int age)
		method.invoke(p, 45);
		
		//获取属性的值
		method = pd.getReadMethod();
		System.out.println(method.invoke(p, null));
		
		System.out.println(p.getAge());
	}
	
	//获取当前属性的类型
	@Test
	public void test3() throws Exception{
		Person p =new Person();
		PropertyDescriptor pd =new PropertyDescriptor("age", Person.class);

		System.out.println(pd.getPropertyType());
	}

}

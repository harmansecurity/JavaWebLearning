package com.ecnu.introspector;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.junit.Test;


//ʹ����ʡapi����bean������
public class Demo1 {
	//�õ�bean����������
	@Test
	public void test1() throws Exception{
		//BeanInfo info = Introspector.getBeanInfo(Person.class); //����class����
		BeanInfo info = Introspector.getBeanInfo(Person.class,Object.class);//bean�Լ�������
		PropertyDescriptor[] pds=info.getPropertyDescriptors();//�õ�����������
		for(PropertyDescriptor pd : pds){
			System.out.println(pd.getName());
		}
	}
	
	//����bean��ָ������
	@Test
	public void test2() throws Exception{
		Person p =new Person();
		PropertyDescriptor pd =new PropertyDescriptor("age", Person.class);
		
		//�õ����Ե�д������Ϊ���Ը�ֵ
		Method method=pd.getWriteMethod();//public void setAge(int age)
		method.invoke(p, 45);
		
		//��ȡ���Ե�ֵ
		method = pd.getReadMethod();
		System.out.println(method.invoke(p, null));
		
		System.out.println(p.getAge());
	}
	
	//��ȡ��ǰ���Ե�����
	@Test
	public void test3() throws Exception{
		Person p =new Person();
		PropertyDescriptor pd =new PropertyDescriptor("age", Person.class);

		System.out.println(pd.getPropertyType());
	}

}

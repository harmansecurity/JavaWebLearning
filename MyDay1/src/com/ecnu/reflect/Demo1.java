package com.ecnu.reflect;

public class Demo1 {

	/**
	 * ����  ������  ��ȡ����ֽ���
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		//1.
		Class clazz=Class.forName("com.ecnu.reflect.Person");
		
		//2.
		Class classzz1=new Person().getClass();
		
		//3.
		Class classzz2=Person.class;//�õ�Person����ֽ���
	}

}

package com.ecnu.enumeration;

import org.junit.Test;

public class Demo1 {
	@Test
	public void test(){
		System.out.println(Grade.A.getValue());
		System.out.println(Grade.A.localValue());
	}
	
	//测试枚举类的常用方法
	@Test
	public void test2(){
		System.out.println(Grade.C.name());
		System.out.println(Grade.C.ordinal());
		
		String str="B";
		Grade g=Grade.valueOf(str);
		System.out.println(g);
	}

}
//如何定义枚举的函数和方法
/*enum Grade{
	A("100"),B("3242"),C("32421"),D("23424"),E("rwqerqwe");
	
	private String value;//封装每个对象对应的值

	public String getValue() {
		return value;
	}

	private Grade(String value) {
		this.value = value;
	}
}*/

//带抽象方法的枚举
enum Grade{
	A("100"){
		public  String localValue(){
			return "42353";
		}
	}
	,B("3242"){
		public  String localValue(){
			return "42353";
		}
	}
	,C("32421"){
		public  String localValue(){
			return "42353";
		}
	}
	,D("23424"){
		public  String localValue(){
			return "42353";
		}
	}
	,E("rwqerqwe"){
		public  String localValue(){
			return "42353";
		}
	};
	
	private String value;//封装每个对象对应的值

	public String getValue() {
		return value;
	}

	private Grade(String value) {//枚举的构造函数必须是私有的
		this.value = value;
	}
	
	public abstract String localValue();
}




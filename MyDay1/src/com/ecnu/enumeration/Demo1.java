package com.ecnu.enumeration;

import org.junit.Test;

public class Demo1 {
	@Test
	public void test(){
		System.out.println(Grade.A.getValue());
		System.out.println(Grade.A.localValue());
	}
	
	//����ö����ĳ��÷���
	@Test
	public void test2(){
		System.out.println(Grade.C.name());
		System.out.println(Grade.C.ordinal());
		
		String str="B";
		Grade g=Grade.valueOf(str);
		System.out.println(g);
	}

}
//��ζ���ö�ٵĺ����ͷ���
/*enum Grade{
	A("100"),B("3242"),C("32421"),D("23424"),E("rwqerqwe");
	
	private String value;//��װÿ�������Ӧ��ֵ

	public String getValue() {
		return value;
	}

	private Grade(String value) {
		this.value = value;
	}
}*/

//�����󷽷���ö��
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
	
	private String value;//��װÿ�������Ӧ��ֵ

	public String getValue() {
		return value;
	}

	private Grade(String value) {//ö�ٵĹ��캯��������˽�е�
		this.value = value;
	}
	
	public abstract String localValue();
}




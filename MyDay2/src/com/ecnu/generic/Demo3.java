package com.ecnu.generic;

import com.sun.accessibility.internal.resources.accessibility;


//自定义泛型的方法
public class Demo3 {
	public void testA(){
		a("aaaaS");
	}
	
	public <T> T a(T t){ //T要先声明<T>再使用
		return null;
	}
	
	public <T,E,K> void b(T t,E e,K k){
		
	}

}

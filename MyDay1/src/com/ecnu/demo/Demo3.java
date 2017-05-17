package com.ecnu.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

//可变参数
public class Demo3 {
	@Test
	public void testSum(){
		sum(1,2,3,4,5,6);
	}
	
	public void sum(int ...nums){
		int sum=0;
		for(int i : nums){
			sum += i;
		}
		System.out.println(sum);
	}
	
	@Test
	public void bb(){
		List list =new ArrayList();
		list=Arrays.asList("1","2","33");//接受的是多个对象
		System.out.println(list);
		
		
		int nums[]={1,2,3};
		list=Arrays.asList(nums);//这边把nums当做一个对象，所以输出的时候不会输出1,2,3
		System.out.println(list);
	}
}

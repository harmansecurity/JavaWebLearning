package com.ecnu.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

//�ɱ����
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
		list=Arrays.asList("1","2","33");//���ܵ��Ƕ������
		System.out.println(list);
		
		
		int nums[]={1,2,3};
		list=Arrays.asList(nums);//��߰�nums����һ���������������ʱ�򲻻����1,2,3
		System.out.println(list);
	}
}

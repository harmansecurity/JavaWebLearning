package com.ecnu.generic;


public class Demo5 {

	
	//��дһ�����͵ķ�����ʵ��ָ��λ���ϵ�����Ԫ�ض��
	public <T> void swap(T arr[],int pos1,int pos2){
		
	}
	
	//��дһ�����͵ķ���������һ���������飬���ߵ������е�����Ԫ��
	public <T> void reverse(T arr[]){
		int start =0;
		int end = arr.length-1;
		
		while(true){
			if(start>=end){
				break;
			}
			T temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			
			start++;
			end--;
		}
	}
}

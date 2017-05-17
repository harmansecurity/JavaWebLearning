package com.ecnu.generic;


public class Demo5 {

	
	//编写一个泛型的方法，实现指定位置上的数组元素额交换
	public <T> void swap(T arr[],int pos1,int pos2){
		
	}
	
	//编写一个泛型的方法，接收一个任意数组，并颠倒数组中的所有元素
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

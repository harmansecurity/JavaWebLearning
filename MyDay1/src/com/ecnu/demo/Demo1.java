package com.ecnu.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Demo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer integer=1;//װ��
		int j=integer;//����
		
		//����Ӧ��
		List list =new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		
		Iterator it=list.iterator();
		while(it.hasNext()) {
			int k=(Integer)it.next();//����
			System.out.println(k);
		}
	}

}

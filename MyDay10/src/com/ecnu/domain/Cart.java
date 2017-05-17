package com.ecnu.domain;

import java.util.LinkedHashMap;
import java.util.Map;

//�����û��Ĺ��ﳵ
public class Cart {
	
	private Map<String, CartItem> map = new LinkedHashMap();	
	private double price;//�����ﳵ�е�������Ʒ����Ǯ
	
	public void add(Book book){
		//�����ﳵ����û��Ҫ��ӵ����Ӧ�Ĺ�����
		CartItem item = map.get(book.getId());
		if(item==null){
			item = new CartItem();
			item.setBook(book);
			item.setQuantity(1);
			map.put(book.getId(), item);
		}else{
			item.setQuantity(item.getQuantity()+1);
		}
	}
	public Map<String, CartItem> getMap() {
		return map;
	}
	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}
	public double getPrice() {
		double totalprice = 0;
		for(Map.Entry<String, CartItem> entry : map.entrySet()){
			CartItem item = entry.getValue();
			totalprice += item.getPrice();
		}
		this.price = totalprice;
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}

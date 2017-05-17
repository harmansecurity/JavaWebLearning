package com.ecnu.domain;

import java.util.LinkedHashMap;
import java.util.Map;

//代表用户的购物车
public class Cart {
	
	private Map<String, CartItem> map = new LinkedHashMap();	
	private double price;//代表购物车中的所有商品多少钱
	
	public void add(Book book){
		//看购物车中有没有要添加的书对应的购物项
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

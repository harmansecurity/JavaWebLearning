package com.ecnu.service;

import java.util.Map;

import com.ecnu.dao.BookDao;
import com.ecnu.domain.Book;
import com.ecnu.domain.Cart;
import com.ecnu.domain.CartItem;

//业务类，统一对web层提供所有服务
public class BussinessService {
	private BookDao dao = new BookDao();
	public Map getAllBook(){
		return dao.getAll();
	}
	public Book findBook(String id){
		return dao.find(id);
	}
	
	//删除购物车中购物项
	public void deleteItem(String id, Cart cart) {
		// TODO Auto-generated method stub
		cart.getMap().remove(id);
	}
	
	public void clearCart(Cart cart) {
		// TODO Auto-generated method stub
		cart.getMap().clear();
	}
	
	public void changeItemQuantity(String id, String quantity, Cart cart) {
		// TODO Auto-generated method stub
		CartItem item = cart.getMap().get(id);
		item.setQuantity(Integer.parseInt(quantity));
	}
}

package com.ecnu.service;

import java.util.Map;

import com.ecnu.dao.BookDao;
import com.ecnu.domain.Book;
import com.ecnu.domain.Cart;
import com.ecnu.domain.CartItem;

//ҵ���࣬ͳһ��web���ṩ���з���
public class BussinessService {
	private BookDao dao = new BookDao();
	public Map getAllBook(){
		return dao.getAll();
	}
	public Book findBook(String id){
		return dao.find(id);
	}
	
	//ɾ�����ﳵ�й�����
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

package com.ecnu.dao;

import java.util.Map;

import com.ecnu.DB.DB;
import com.ecnu.domain.Book;


public class BookDao {
	public Map getAll(){
		return DB.getAll();
	}
	
	public Book find(String id){
		return (Book)DB.getAll().get(id);
	}
}

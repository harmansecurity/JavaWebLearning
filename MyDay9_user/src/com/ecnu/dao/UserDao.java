package com.ecnu.dao;

import com.ecnu.domain.User;

public interface UserDao {

	public abstract void add(User user);

	public abstract User find(String username, String password);

	//����ע����û��Ƿ������ݿ��д���
	public abstract Boolean find(String username);

}
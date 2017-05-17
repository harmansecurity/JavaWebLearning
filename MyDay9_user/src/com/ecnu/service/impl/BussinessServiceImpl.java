package com.ecnu.service.impl;

import com.ecnu.dao.UserDao;
import com.ecnu.dao.impl.UserDaoImpl;
import com.ecnu.domain.User;
import com.ecnu.exception.UserExistException;
import com.ecnu.utils.ServiceUtils;

//对web层提供所有的业务服务
public class BussinessServiceImpl {
	
	private UserDao dao = new UserDaoImpl(); //工厂模式  spring
	//对web层提供注册服务
	public void register(User user) throws UserExistException{
		//先判断当前注册的用户是否存在
		boolean b = dao.find(user.getUsername());
		if(b){
			//System.out.println("用户已存在");
			throw new UserExistException(); //发现要注册的用户已经存在，则向web层抛一个异常
		}else{
			//System.out.println(user.getPassword());
			user.setPassword(ServiceUtils.md5(user.getPassword()));//密码设置成MD5
			//System.out.println("md5");
			dao.add(user);
			//System.out.println(123345);
		}
	}
	//对web层提供登录服务
	public User login(String username,String password){
		password = ServiceUtils.md5(password);
		return dao.find(username, password);
	}
}

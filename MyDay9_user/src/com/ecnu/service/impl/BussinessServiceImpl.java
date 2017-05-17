package com.ecnu.service.impl;

import com.ecnu.dao.UserDao;
import com.ecnu.dao.impl.UserDaoImpl;
import com.ecnu.domain.User;
import com.ecnu.exception.UserExistException;
import com.ecnu.utils.ServiceUtils;

//��web���ṩ���е�ҵ�����
public class BussinessServiceImpl {
	
	private UserDao dao = new UserDaoImpl(); //����ģʽ  spring
	//��web���ṩע�����
	public void register(User user) throws UserExistException{
		//���жϵ�ǰע����û��Ƿ����
		boolean b = dao.find(user.getUsername());
		if(b){
			//System.out.println("�û��Ѵ���");
			throw new UserExistException(); //����Ҫע����û��Ѿ����ڣ�����web����һ���쳣
		}else{
			//System.out.println(user.getPassword());
			user.setPassword(ServiceUtils.md5(user.getPassword()));//�������ó�MD5
			//System.out.println("md5");
			dao.add(user);
			//System.out.println(123345);
		}
	}
	//��web���ṩ��¼����
	public User login(String username,String password){
		password = ServiceUtils.md5(password);
		return dao.find(username, password);
	}
}

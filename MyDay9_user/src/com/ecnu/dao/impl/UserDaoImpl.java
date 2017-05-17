package com.ecnu.dao.impl;

import java.text.SimpleDateFormat;

import org.dom4j.Document;
import org.dom4j.Element;

import com.ecnu.dao.UserDao;
import com.ecnu.domain.User;
import com.ecnu.utils.XmlUtils;


public class UserDaoImpl implements UserDao {
	public void add(User user){
		try {
			//System.out.println(user.getId());
			Document document = XmlUtils.getDocument();
			Element root = document.getRootElement(); 
			Element user_tag = root.addElement("user");
			user_tag.setAttributeValue("id", user.getId());
			user_tag.setAttributeValue("username", user.getUsername());
			user_tag.setAttributeValue("password", user.getPassword());
			user_tag.setAttributeValue("email", user.getEmail());
			user_tag.setAttributeValue("birthday", user.getBirthday()==null?"":user.getBirthday().toLocaleString());
			user_tag.setAttributeValue("nickname", user.getNickname());
			XmlUtils.write2Xml(document);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
	public User find(String username,String password){
		try {
			Document document = XmlUtils.getDocument();
			Element e = (Element) document.selectSingleNode("//user[@username='"+username+"' and @password='"+password+"']");
			if(e==null){
				return null;
			}
			User user = new User();
			String date = e.attributeValue("birthday");
			if(date == null || date.equals("")){
				user.setBirthday(null);
			}else {
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				user.setBirthday(df.parse(date));
			}
			user.setEmail(e.attributeValue("email"));
			user.setEmail(e.attributeValue("id"));
			user.setEmail(e.attributeValue("nickname"));
			user.setEmail(e.attributeValue("password"));
			user.setEmail(e.attributeValue("username"));
			return user;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
	//查找注册的用户是否在数据库中存在
	public Boolean find(String username){
		try {
			Document document = XmlUtils.getDocument();
			Element e = (Element) document.selectSingleNode("//user[@username='"+username+"']");
			if(e==null){
				return false;
			}
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
}

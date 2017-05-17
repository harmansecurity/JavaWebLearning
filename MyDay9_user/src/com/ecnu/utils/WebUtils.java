package com.ecnu.utils;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

public class WebUtils {
	
	public static <T> T request2Bean(HttpServletRequest request,Class<T> beanClass){
		
		try {
			//创建封装数据的bean
			T bean = beanClass.newInstance();
			//把数据封装到bean中 (用枚举有bug)
			/*Enumeration e  = request.getParameterNames();
			while (e.hasMoreElements()) {
				String name = (String) e.nextElement();//username password email birthday
				String value = request.getParameter(name);//aaa 12
				//System.out.println(name+":"+value);
				System.out.println(request.getParameter("username"));
				System.out.println(request.getParameter("password2"));
				System.out.println(name);
				BeanUtils.setProperty(bean, name, value);
			}*/
			BeanUtils.setProperty(bean, "username", request.getParameter("username"));
			BeanUtils.setProperty(bean, "password", request.getParameter("password"));
			BeanUtils.setProperty(bean, "password2", request.getParameter("password2"));
			BeanUtils.setProperty(bean, "birthday", request.getParameter("birthday"));
			BeanUtils.setProperty(bean, "email", request.getParameter("email"));
			BeanUtils.setProperty(bean, "nickname", request.getParameter("nickname"));
			return bean;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		} //反射
	}
/*
 * 	private String username;
	private String password;
	private String password2;
	private String email;
	private String birthday;
	private String nickname;
	
    private String id;
	private String username;
	private String password;
	private String email;
	private Date birthday;
	private String nickname;
 */
	public static void copyBean(Object src,Object dest){
		//注册日期转化器
		ConvertUtils.register(new Converter() {
			
			@Override
			public Object convert(Class type, Object value) {
				// TODO Auto-generated method stub
				if(value==null){
					return null;
				}
				String str = (String)value;
				if(str.trim().equals("")){
					return null;
				}
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				try {
					return df.parse(str);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					throw new RuntimeException();
				}
			}
		}, Date.class);
		
		try {
			BeanUtils.copyProperties(src, dest);
			//System.out.println(dest.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
	//产生全球唯一的id
	public static String generatorId(){
		return UUID.randomUUID().toString();
	}
}

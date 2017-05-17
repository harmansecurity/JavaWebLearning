package com.ecnu.web.formbean;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class RegisterForm {
	private String username;
	private String password;
	private String password2;
	private String email;
	private String birthday;
	private String nickname;
	private Map errors = new HashMap();
	
	public Map getErrors() {
		return errors;
	}
	public void setErrors(Map errors) {
		this.errors = errors;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	//�û�������Ϊ�գ�3-8λ����
	//���벻��Ϊ�գ�3-8
	//ȷ�����벻��Ϊ�գ����Һ�һ��һ��
	//�������䲻��Ϊ�գ�����Ҫ��һ����ʽ�Ϸ�������
	//���տ���Ϊ�գ���Ϊ�ձ�����һ������
	//�ǳƲ�����Ϊ�գ�����Ҫ�Ǻ���
	public boolean validate(){
		boolean isOK = true;
		if(this.username==null||this.username.trim().equals("")){
			isOK = false;
			errors.put("username", "�û�������Ϊ�գ�");
		}else{
			if(!this.username.matches("[A-Za-z]{3,8}")){
				isOK = false;
				errors.put("username", "�û���������3-8λ��ĸ");
			}
		}
		
		if(this.password==null||this.password.trim().equals("")){
			isOK = false;
			errors.put("password", "���벻��Ϊ�գ�");
		}else{
			if(!this.password.matches("\\d{3,8}")){
				isOK = false;
				errors.put("password", "���������3-8λ����");
			}
		}
		
		if(this.password2==null||this.password2.trim().equals("")){
			isOK = false;
			errors.put("password2", "���벻��Ϊ�գ�");
		}else{
			if(!this.password.equals(this.password2)){
				isOK = false;
				errors.put("password2", "������ԿҪһ�£�");
			}
		}
		
		if(this.email==null||this.email.trim().equals("")){
			isOK = false;
			errors.put("email", "���䲻��Ϊ�գ�");
		}else{
			//\\w+@\\w+(\\.\\w+)+
			if(!this.email.matches("\\w+@\\w+(\\.\\w+)+")){
				isOK = false;
				errors.put("email", "�����ʽ���ԣ�");
			}
		}
		
		if(this.birthday!=null&&!this.birthday.trim().equals("")){
			try {
				DateLocaleConverter dic = new DateLocaleConverter();
				dic.convert(this.birthday, "yyyy-MM-dd");
			} catch (Exception e) {
				// TODO: handle exception
				isOK = false;
				errors.put("birthday", "���ڸ�ʽ���ԣ�");
			}
		}
		
		if(this.nickname==null||this.nickname.trim().equals("")){
			isOK = false;
			errors.put("nickname", "�ǳƲ���Ϊ�գ�");
		}else{
			if(!this.nickname.matches("^([\u4e00-\u9fa5]+)$")){
				isOK = false;
				errors.put("nickname", "�ǳƱ����Ǻ���");
			}
		}
		return isOK;
	}
}

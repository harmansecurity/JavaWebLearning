package com.ecnu.form;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.management.RuntimeErrorException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;

public class FormServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//���������(����)
		TokenProcessor tp = TokenProcessor.getInstance();
		String token = tp.generatorToken();
		
		request.getSession().setAttribute("token", token);
		
		request.getRequestDispatcher("/form.jsp").forward(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

class TokenProcessor{ //����
	/*
	 * 1.���췽��˽��
	 * 2.�Լ�����һ��
	 * 3.���Ⱪ¶һ�������������ȡ���洴���Ķ���
	 */
	private TokenProcessor(){}
	private static final TokenProcessor instance = new TokenProcessor();
	public static TokenProcessor getInstance(){
		return instance;
	}
	
	public String generatorToken(){
		//�õ�����������Ȳ�һ��
		String token = System.currentTimeMillis() + new Random().nextInt() + "";
		
		//Ϊ�˱�֤����һ��
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte [] md5 = md.digest(token.getBytes());
			
			//base64����
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(md5);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
}

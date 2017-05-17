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

		//产生随机数(表单号)
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

class TokenProcessor{ //令牌
	/*
	 * 1.构造方法私有
	 * 2.自己创建一个
	 * 3.对外暴露一个方法，允许获取上面创建的对象
	 */
	private TokenProcessor(){}
	private static final TokenProcessor instance = new TokenProcessor();
	public static TokenProcessor getInstance(){
		return instance;
	}
	
	public String generatorToken(){
		//得到的随机数长度不一样
		String token = System.currentTimeMillis() + new Random().nextInt() + "";
		
		//为了保证长度一样
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte [] md5 = md.digest(token.getBytes());
			
			//base64编码
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(md5);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
}

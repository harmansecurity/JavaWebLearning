package com.ecnu.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//通过response的write流输出数据的问题
public class ResponseDemo2 extends HttpServlet {

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
		test1(response);

	}

	private void test1(HttpServletResponse response) throws IOException {
		//设置response使用的码表，以控制response以什么码表向浏览器写出数据
		response.setCharacterEncoding("UTF-8");
		//指定浏览器以什么码表打开服务器发送的数据
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		String data = "中国";
		PrintWriter pw = response.getWriter();
		pw.write(data);
	}
	
	private void test2(HttpServletResponse response) throws IOException {
		//设置response使用的码表，以控制response以什么码表向浏览器写出数据
		//response.setCharacterEncoding("UTF-8");
		//指定浏览器以什么码表打开服务器发送的数据
		//response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String data = "中国";
		PrintWriter pw = response.getWriter();
		pw.write(data);
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

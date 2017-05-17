package com.ecnu.request;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.mail.iap.Response;

public class RequestDemo4 extends HttpServlet {

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
		
		/*String username = request.getParameter("username");
		username = new String(username.getBytes("iso8859-1"), "UTF-8");
		System.out.println(username);*/
		test3(request, response);
	}

	//测试题
	private void test3(HttpServletRequest request,HttpServletResponse response)
			throws IOException {
		request.setCharacterEncoding("UTF-8");//只对post有效
		String username = request.getParameter("username");
		
		response.setCharacterEncoding("gb2312");
		response.setContentType("text/html;charset=gb2312");
		response.getWriter().write(username);
	}
	//解决get提交乱码问题
	private void test1(HttpServletRequest request)
			throws UnsupportedEncodingException {
		String username = request.getParameter("username");
		username = new String(username.getBytes("iso8859-1"), "UTF-8");
		System.out.println(username);
	}
	
	//解决post提交乱码问题
	private void test2(HttpServletRequest request)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");//只对post有效
		String username = request.getParameter("username");
		System.out.println(username);
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

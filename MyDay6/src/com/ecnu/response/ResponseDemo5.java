package com.ecnu.response;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//控制浏览器定时刷新
public class ResponseDemo5 extends HttpServlet {

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
		test3(request, response);
		//test2(response);
		//test1(response);
	}
//实现的自动跳转技术
	private void test3(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//假设这是一个用于处理登录的servlet
		//假设程序运行到此，用户登录成功
		String message = "<meta http-equiv='refresh' content='3;url='/MyDay6/index.jsp'>恭喜你，登录成功，将在三秒之后跳到首页，如果没有跳，请点<a href=''>超链接</a>";
		this.getServletContext().setAttribute("message",message);
		this.getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
	}
	
	private void test2(HttpServletResponse response) throws IOException {
		//假设这是一个用于处理登录的servlet
		//假设程序运行到此，用户登录成功
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("refresh", "3;url='/MyDay6/index.jsp'");
		response.getWriter().write("恭喜你，登录成功，将在三秒之后跳到首页，如果没有跳，请点" +
				"<a href=''>超链接</a>");
	}

	private void test1(HttpServletResponse response) throws IOException {
		response.setHeader("refresh", "3");
		String data = new Random().nextInt(10000000) + "";
		response.getWriter().write(data);
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

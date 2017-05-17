package com.ecnu.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//处理表单提交请求
public class DoFormServlet extends HttpServlet {

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
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("向数据库中注册用户");*/
		boolean b = isTokenValid(request);
		if(!b){
			System.out.println("请不要重复提交！！！");
			return;
		}
		
		request.getSession().removeAttribute("token");
		System.out.println("向数据库中注册用户");
	}

	//判断表单号是否有效
	private boolean isTokenValid(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String client_token = request.getParameter("token");
		if(client_token==null){
			return false;
		}
		String server_token = (String) request.getSession().getAttribute("token");
		if(server_token==null){
			return false;
		}
		
		if(server_token==client_token){
			return false;
		}
		return true;
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

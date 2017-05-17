package com.ecnu.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//������վ��ҳ
public class CookieDemo1 extends HttpServlet {

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
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<a href='/MyDay7/servlet/CookieDemo2'>����ϴη���ʱ��</a><br/>");
		out.print("���ϴη���ʱ���ǣ�<br>");
		//����û���ʱ��cookie
		Cookie cookies[] = request.getCookies();
		for(int i = 0;cookies!=null&&i<cookies.length;i++){
			if(cookies[i].getName().equals("lastAccessTime")){
				long cookieValue = Long.parseLong(cookies[i].getValue());
				Date date = new Date(cookieValue);
				out.print(date.toLocaleString());
			}
		}
		//���û��������µķ���ʱ��
		Cookie cookie = new Cookie("lastAccessTime", System.currentTimeMillis()+"");
		cookie.setMaxAge(30*24*3600);
		cookie.setPath("/MyDay7");
		
		response.addCookie(cookie);
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

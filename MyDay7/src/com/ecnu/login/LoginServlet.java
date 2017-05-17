package com.ecnu.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

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
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		List<User> list = DB.getAll();
		for(User user : list){
			if(user.getUsername().equals(username)&&user.getPassword().equals(password)){
				request.getSession().setAttribute("user", user);//登录成功，向Session存入一个登录标记
				response.sendRedirect("/MyDay7/index.jsp");
				return;
			}
		}
		out.write("登录密码不对！！！");
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

class DB{
	public static List list = new ArrayList();
	static{
		list.add(new User("aaa","23424"));
		list.add(new User("bbb","23424"));
		list.add(new User("ccc","23424"));
	}
	public static List getAll(){
		return list;
	}
}

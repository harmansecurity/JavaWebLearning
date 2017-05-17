package com.ecnu.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecnu.domain.User;
import com.ecnu.exception.UserExistException;
import com.ecnu.service.impl.BussinessServiceImpl;
import com.ecnu.utils.WebUtils;
import com.ecnu.web.formbean.RegisterForm;
//处理注册请求
public class RegisterServlet extends HttpServlet {

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

		request.setCharacterEncoding("UTF-8");
		//1.对提交的表单进行合法性校验(formBean)
		RegisterForm form = WebUtils.request2Bean(request, RegisterForm.class);
		boolean b = form.validate();
		//2.如果校验失败，跳回到表单页面，回显校验失败信息
		if(!b){
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		}
		//3.如果校验成功，则调用service处理注册请求
		User user = new User();
		WebUtils.copyBean(form, user);
		user.setId(WebUtils.generatorId());
		//System.out.println(user.getId());
		BussinessServiceImpl service = new BussinessServiceImpl();
		try {
			service.register(user);
			//System.out.println("lalalalal");
			request.setAttribute("message", "恭喜您注册成功");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		} catch (UserExistException e) {
			//4.如果service处理不成功，是因为用户已存在的话，则跳回到注册页面，显示注册用户已存在
			form.getErrors().put("username", "注册的用户名已存在");
			request.setAttribute("form", form);
			//request.setAttribute("message", "注册的用户名已存在");
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		}catch (Exception e) {
			//5.如果service处理不成功，跳转到网站的全局消息显示页面，为用户显示友好错误消息
			request.setAttribute("message", "服务器出现未知错误");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		
		
		//6.如果service处理成功，跳转到网站的全局消息显示页面，为用户注册成功的消息
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

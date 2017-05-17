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
//����ע������
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
		//1.���ύ�ı����кϷ���У��(formBean)
		RegisterForm form = WebUtils.request2Bean(request, RegisterForm.class);
		boolean b = form.validate();
		//2.���У��ʧ�ܣ����ص���ҳ�棬����У��ʧ����Ϣ
		if(!b){
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		}
		//3.���У��ɹ��������service����ע������
		User user = new User();
		WebUtils.copyBean(form, user);
		user.setId(WebUtils.generatorId());
		//System.out.println(user.getId());
		BussinessServiceImpl service = new BussinessServiceImpl();
		try {
			service.register(user);
			//System.out.println("lalalalal");
			request.setAttribute("message", "��ϲ��ע��ɹ�");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		} catch (UserExistException e) {
			//4.���service�����ɹ�������Ϊ�û��Ѵ��ڵĻ��������ص�ע��ҳ�棬��ʾע���û��Ѵ���
			form.getErrors().put("username", "ע����û����Ѵ���");
			request.setAttribute("form", form);
			//request.setAttribute("message", "ע����û����Ѵ���");
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		}catch (Exception e) {
			//5.���service�����ɹ�����ת����վ��ȫ����Ϣ��ʾҳ�棬Ϊ�û���ʾ�Ѻô�����Ϣ
			request.setAttribute("message", "����������δ֪����");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		
		
		//6.���service����ɹ�����ת����վ��ȫ����Ϣ��ʾҳ�棬Ϊ�û�ע��ɹ�����Ϣ
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

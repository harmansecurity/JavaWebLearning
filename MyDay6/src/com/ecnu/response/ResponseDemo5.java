package com.ecnu.response;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//�����������ʱˢ��
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
//ʵ�ֵ��Զ���ת����
	private void test3(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//��������һ�����ڴ����¼��servlet
		//����������е��ˣ��û���¼�ɹ�
		String message = "<meta http-equiv='refresh' content='3;url='/MyDay6/index.jsp'>��ϲ�㣬��¼�ɹ�����������֮��������ҳ�����û���������<a href=''>������</a>";
		this.getServletContext().setAttribute("message",message);
		this.getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
	}
	
	private void test2(HttpServletResponse response) throws IOException {
		//��������һ�����ڴ����¼��servlet
		//����������е��ˣ��û���¼�ɹ�
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("refresh", "3;url='/MyDay6/index.jsp'");
		response.getWriter().write("��ϲ�㣬��¼�ɹ�����������֮��������ҳ�����û���������" +
				"<a href=''>������</a>");
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

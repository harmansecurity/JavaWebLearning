package com.ecnu.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//ͨ��response��write��������ݵ�����
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
		//����responseʹ�õ�����Կ���response��ʲô����������д������
		response.setCharacterEncoding("UTF-8");
		//ָ���������ʲô���򿪷��������͵�����
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		String data = "�й�";
		PrintWriter pw = response.getWriter();
		pw.write(data);
	}
	
	private void test2(HttpServletResponse response) throws IOException {
		//����responseʹ�õ�����Կ���response��ʲô����������д������
		//response.setCharacterEncoding("UTF-8");
		//ָ���������ʲô���򿪷��������͵�����
		//response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String data = "�й�";
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

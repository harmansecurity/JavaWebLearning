package com.ecnu.response;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo1 extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	// 在servlet中用OutputSream输出数据的问题以及输出中文的问题
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// test1(response);
		//test2(response);
		test3(response);
	}

	private void test3(HttpServletResponse response) throws IOException,
			UnsupportedEncodingException {

		OutputStream os = response.getOutputStream();
		os.write((1+"").getBytes("UTF-8"));
	}

	private void test2(HttpServletResponse response) throws IOException,
			UnsupportedEncodingException {
		// 用html技术中meta标签模拟一个http响应头来控制浏览器的行为
		String data = "中国";
		OutputStream os = response.getOutputStream();
		os
				.write("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/>"
						.getBytes());
		os.write(data.getBytes("UTF-8"));
	}

	private void test1(HttpServletResponse response) throws IOException,
			UnsupportedEncodingException {
		// 程序以什么码表输出，就一定要控制浏览器以什么码表打开
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		String data = "中国";
		OutputStream os = response.getOutputStream();
		os.write(data.getBytes("UTF-8"));
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

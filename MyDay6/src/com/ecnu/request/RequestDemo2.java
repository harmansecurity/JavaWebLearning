package com.ecnu.request;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.ecnu.bean.User;

public class RequestDemo2 extends HttpServlet {

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
		
		
		
	}
	//��ȡ��������
	private void test2(HttpServletRequest request) throws IOException {
		System.out.println("-------��ȡ���ݷ�ʽ1-----------");
		String value = request.getParameter("username");
		if(value!=null&&!value.trim().endsWith("")){
			System.out.println(value);
		}
		
		System.out.println("-------��ȡ���ݷ�ʽ2-----------");
		Enumeration<String> e = request.getParameterNames();
		while (e.hasMoreElements()) {
			String name = (String) e.nextElement();
			value = request.getParameter(name);
			System.out.println(name + "=" + value);
			
		}
		
		System.out.println("------��ȡ���ݷ�ʽ3------------");
		String []values = request.getParameterValues("username");
		for(int i=0;values!=null&&i<values.length;i++){
			System.out.println(values[i]);
		}
		
		System.out.println("------��ȡ���ݷ�ʽ4------------");
		Map<String,String []> map = request.getParameterMap();	
		User user = new User();
		try {
			BeanUtils.populate(user, map);//username string[]���Ҳ�õ��˷��似��//��map���ϵ��������bean
		    //BeanUtils.copyProperties(dest, orig);//bean�Ŀ���
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(user);
		
		System.out.println("------��ȡ���ݷ�ʽ5------------");
		InputStream in = request.getInputStream();
		int len = 0;
		byte buffer[] = new byte[1024];
		while ((len=in.read(buffer))>0) {
			System.out.println(new String(buffer,0,len));
		}
	}
	//��ȡͷ��صķ���
	private void test1(HttpServletRequest request) {
		String headValue = request.getHeader("Accept-Encoding");
		System.out.println(headValue);
		
		Enumeration e = request.getHeaders("Accept-Encoding");
		while(e.hasMoreElements()){
			String value = (String) e.nextElement();
			System.out.println(value);
		}
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

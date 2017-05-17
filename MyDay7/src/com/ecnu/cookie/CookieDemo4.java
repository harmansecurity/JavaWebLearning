package com.ecnu.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CookieDemo4 extends HttpServlet {

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
		//根据用户传过来的id,显示相应商品的详细信息
		String id = request.getParameter("id");
		Book book = (Book)Db.getAll().get(id);
		out.write(book.getName()+"<br/>");
		
		//构建cookie，回写给cookie
		String cookieValue = buildCookie(id,request);
		Cookie cookie = new Cookie("bookHistory", cookieValue);
		cookie.setMaxAge(30*24*3600);
		cookie.setPath("/MyDay7");
		response.addCookie(cookie);
	}

	private String buildCookie(String id, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		String bookHistory = null;
		Cookie cookies[]=request.getCookies();
		for(int i=0;cookies!=null&&i<cookies.length;i++){
			if(cookies[i].getName().equals("bookHistory")){
				bookHistory = cookies[i].getValue();
			}
		}
		if(bookHistory==null){
			//bookHistory=null     1  1
			return id;
		}
		LinkedList<String> list = new LinkedList(Arrays.asList(bookHistory.split("\\,")));
		/*if(list.contains(id)){
			//bookHistory=2,5,1    1  1,2,5
			list.remove(id);
			list.addFirst(id);
		}else{
			if(list.size()>=3){
				//bookHistory=2,5,4    1  1,2,5
				list.removeLast();
				list.addFirst(id);
			}else {
				//bookHistory=2,5      1  1,2,5
				list.addFirst(id);
			}
		}*/
		if(list.contains(id)){
			list.remove(id);
		}else{
			if(list.size()>=3){
				list.removeLast();
			}
		}
	    list.addFirst(id);
	    
	    StringBuffer sb = new StringBuffer();
	    for(String bid: list){
	    	sb.append(bid+",");
	    }
	    return sb.deleteCharAt(sb.length()-1).toString();
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

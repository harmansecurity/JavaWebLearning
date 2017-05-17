package com.ecnu.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//代表首页的servlet
public class CookieDemo3 extends HttpServlet {

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
		//1.输出网站所有商品
		out.write("本网站有如下的商品：<br/>");
		Map<String, Book> map = Db.getAll();
		for(Map.Entry<String, Book> entry : map.entrySet()){
			Book book = entry.getValue();
			out.print("<a href='/MyDay7/servlet/CookieDemo4?id="+book.getId()+"' target='_blank'>"+book.getName()+"</a><br/>");
		}
		//2.输出用户曾经看过的商品
		out.print("<br/>您曾经看过如下商品：<br/>");
		Cookie cookies[]=request.getCookies();
		for(int i=0;cookies!=null&&i<cookies.length;i++){
			if(cookies[i].getName().equals("bookHistory")){
				String ids[] = cookies[i].getValue().split("\\,");
				for (String id : ids) {
					Book book = (Book)Db.getAll().get(id);
					out.print(book.getName()+"<br/>");
				}
			}
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
class Db{
	private static Map<String,Book> map = new LinkedHashMap();
	static{
		map.put("1", new Book("1", "javaweb", "老张", "一本好书！"));
		map.put("2", new Book("2", "java", "老里", "一本好书！"));
		map.put("3", new Book("3", "mysql", "老胡", "一本好书！"));
		map.put("4", new Book("4", "sqlserver", "老王", "一本好书！"));
		map.put("5", new Book("5", "python", "老毕", "一本好书！"));
	}
	
	public static Map getAll(){
		return map;
	}
}
class Book{
	private String id;
	private String name;
	private String author;
	private String description;
	
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String id, String name, String author, String description) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
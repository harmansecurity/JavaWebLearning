package com.ecnu.shopping;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//������վ���г�������
public class ListBookServlet extends HttpServlet {

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
		
		out.print("����վ��������Ʒ:<br/>");
		Map<String, Book> map = Db.getAll();
		for(Map.Entry<String , Book> entry : map.entrySet()){
			Book book = entry.getValue();
			out.print(book.getName()+"<a href='/MyDay7/servlet/BuyServlet?id="+book.getId()+"' target='_blank'>����</a><br/>");
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
		map.put("1", new Book("1", "javaweb", "����", "һ�����飡"));
		map.put("2", new Book("2", "java", "����", "һ�����飡"));
		map.put("3", new Book("3", "mysql", "�Ϻ�", "һ�����飡"));
		map.put("4", new Book("4", "sqlserver", "����", "һ�����飡"));
		map.put("5", new Book("5", "python", "�ϱ�", "һ�����飡"));
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

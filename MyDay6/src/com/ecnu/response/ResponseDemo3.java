package com.ecnu.response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//文件下载
public class ResponseDemo3 extends HttpServlet {

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
		//在servlet中读取资源用getServletContext，其他地方用类加载器去读取资源。
		String path = this.getServletContext().getRealPath("/download/学习路线.png");
		String filename = path.substring(path.lastIndexOf("\\")+1);
		//如果下载文件是中文文件，则文件名需要经过URL编码
		response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(filename,"UTF-8"));
		
		InputStream in = null;
		OutputStream out =null;
		try {
			in = new FileInputStream(path);
			int len =0;
			byte buffer[]=new byte[1024];
			out=response.getOutputStream();
			while((len=in.read(buffer))>0){
				out.write(buffer,0,len);
			}
		} finally{
			if(in!=null){
				try {
					in.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			if(out!=null){
				try {
					out.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
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

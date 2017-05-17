package com.ecnu.response;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//输出一张随机图片
public class ResponseDemo4 extends HttpServlet {

	public static final int WIDTH = 120;
	public static final int HEIGHT = 25;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();

		// 1.设置背景色
		setBackground(g);
		// 2.设置边框
		setBorder(g);
		// 3.画干扰线
		drawRandomLine(g);
		// 4.写随机数
		drawRandomNum((Graphics2D)g);
		// 5.图形写给浏览器
		response.setContentType("image/jpeg");
		//控制浏览器不要缓存
		response.setDateHeader("exprise", -1);
		response.setHeader("Cache-Control", "no-chache");
		response.setHeader("Pragma", "no-chache");
		ImageIO.write(image, "jpg", response.getOutputStream());
	}

	private void setBackground(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, WIDTH, HEIGHT);
	}

	private void setBorder(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLUE);
		g.drawRect(1, 1, WIDTH - 2, HEIGHT - 2);
	}

	private void drawRandomLine(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.GREEN);
		for (int i = 0; i < 5; i++) {
			int x1 = new Random().nextInt(WIDTH);
			int y1 = new Random().nextInt(HEIGHT);

			int x2 = new Random().nextInt(WIDTH);
			int y2 = new Random().nextInt(HEIGHT);

			g.drawLine(x1, y1, x2, y2);
		}
	}

	private void drawRandomNum(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(Color.RED);
		g.setFont(new Font("宋体",Font.BOLD,20));
		
		//[\u4e00-\u9fa5]
		String base = "\u7684\u4e00\u4e86\u4e0d\u5728\u4eec\u6709";
		 int x = 10;
		for (int i = 0; i < 4; i++) {
			int degree =new Random().nextInt()%30;//-30到30
			String ch = base.charAt(new Random().nextInt(base.length()))+"";
			g.rotate(degree*Math.PI/180, x, 20);//设置旋转角度
			g.drawString(ch, x, 20);
			g.rotate(-degree*Math.PI/180, x, 20);//设置旋转角度
			x+=30;
		}
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

package com.itheima.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet response的字节流和字符流向页面做出响应。
 */
public class OutPrintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//字节英文向页面输出
		//outputStream(response);
		//字节流输出中文
		//outputStreamForChinese(response);
		//字符流向页面输出
		//writerStream(response);
		//字符流向页面输出中文
		writerStreamForChinese(response);
	
	}

	private void writerStreamForChinese(HttpServletResponse response) throws IOException {
		//设置浏览器打开时候的字符集编码
		response.setHeader("Content-Type", "text/html;charset=utf-8");
		
		//设置response缓冲区的字符编码
		response.setCharacterEncoding("utf-8");
		
		//简写
		//response.setContentType("text/html;charset=utf-8");
		response.getWriter().println("中文");
		
	}

	/**
	 * 字符流向页面输出
	 * @param response
	 * @throws IOException
	 */
	private void writerStream(HttpServletResponse response) throws IOException {
		response.getWriter().println("response getWriter");
		response.getWriter().write("response getWriter");
	}
	
	private void outputStreamForChinese(HttpServletResponse response) throws UnsupportedEncodingException, IOException {
		//设置浏览器打开时候采用的字符集编码
		response.setHeader("Content-Type", "text/html;charset=utf-8");
		
		//设置中文转字节数组的时候取出的编码
		response.getOutputStream().write("中文".getBytes("utf-8"));
	}

	/**
	 * 字节英文向页面输出
	 * @param response
	 * @throws IOException
	 */
	private void outputStream(HttpServletResponse response) throws IOException {
		response.getOutputStream().print("hello getOutputStream");
		response.getOutputStream().write("hello getOutputStream".getBytes());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

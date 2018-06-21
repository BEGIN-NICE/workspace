package com.itheima.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.utils.ReadFileUtil;

/**
 * Servlet implementation class ReadFileServlet
 */
public class ReadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ReadFileServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		readFileTest();
//		getInitParamentNameAndValue();
//		getFileMIME();
		//使用类的加载器读取文件
//		ReadFileUtil.readFile();
		
		ServletContext context = this.getServletContext();
		InputStream inputStream = new FileInputStream("WEB-INF/classes/c3p0-config.xml");
		
		int len;
		byte[] buf = new byte[1024];
		while((len = inputStream.read(buf))!=-1) {
			System.out.println(new String(buf, 0, len));
		}
		inputStream.close();
	}

	/**
	 * 获取文件的MIME类型
	 */
	private void getFileMIME() {
		ServletContext context = this.getServletContext();
		String type = context.getMimeType("1.jpg");
		System.out.println(type);
	}

	/**
	 * 获取xml中配置的全局变量
	 */
	private void getInitParamentNameAndValue() {
		ServletContext context = this.getServletContext();
		String string = context.getInitParameter("username");
		System.out.println(string);
		Enumeration<String> names = context.getInitParameterNames();
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			String value = context.getInitParameter(name);
			System.out.println("name  "+name +"   =====    value   "+value);			
		}
	}

	/**
	 * web工程中读取本地文件
	 * @throws IOException
	 */
	private void readFileTest() throws IOException {
		ServletContext context = this.getServletContext();
		InputStream inputStream = context.getResourceAsStream("WEB-INF/classes/c3p0-config.xml");
		
		int len;
		byte[] buf = new byte[1024];
		while((len = inputStream.read(buf))!=-1) {
			System.out.println(new String(buf, 0, len));
		}
		inputStream.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

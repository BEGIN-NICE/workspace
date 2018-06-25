package com.itheima.demo1_filedownload;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;



/**
 * Servlet implementation class FileDownLoadServlet
 */
public class FileDownLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
/**
 * 文件下载：设置两个头，一个流
 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filename = request.getParameter("filename");
		//filename = new String(filename.getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(filename);
		InputStream inputStream = this.getServletContext().getResourceAsStream("/download/"+filename);
		String type = this.getServletContext().getMimeType(filename);
		response.setHeader("Content-Type", type);
		String browserType = request.getHeader("User-Agent");
		if(browserType.contains("FireFox")) {
			filename = base64EncodeFileName(filename);
		}else {
			filename = URLEncoder.encode(filename, "utf-8");
		}
		response.setHeader("Content-Disposition", "attachment;filename="+filename);
		
		ServletOutputStream outputStream = response.getOutputStream();
		int len;
		byte[] buf = new byte[1024];
		while((len = inputStream.read(buf))!= -1) {
			outputStream.write(buf, 0, len);
		}
		inputStream.close();
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	/**
	 * 火狐浏览器的BASE64编码
	 * @param fileName
	 * @return
	 */
	public static String base64EncodeFileName(String fileName) {
		BASE64Encoder base64Encoder = new BASE64Encoder();
		try {
			return "=?UTF-8?B?"
					+ new String(base64Encoder.encode(fileName
							.getBytes("UTF-8"))) + "?=";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}

package com.itheima.demo1_filedownload;

import com.itheima.utils.BaseServlet;

import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.AsyncContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDownLoadServlet2
 */
public class FileDownLoadServlet2 extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public String demo1(HttpServletRequest request,HttpServletResponse response) {
		
		try {
			String filename = request.getParameter("filename");
			filename = new String(filename.getBytes("ISO-8859-1"),"utf-8");
			String mimeType = this.getServletContext().getMimeType(filename);
			response.setHeader("Content-Type", mimeType);
			String realPath = this.getServletContext().getRealPath("/download/"+filename);
			InputStream inputStream = new FileInputStream(realPath);
			String header = request.getHeader("User-Agent");
			if(header.contains("FireFox")) {
				filename=base64EncodeFileName(filename);
						
			}else {
				filename = URLEncoder.encode(filename, "utf-8");
			}
			response.setHeader("Content-Disposition", "attachment;filename="+filename);
			ServletOutputStream outputStream = response.getOutputStream();
			int len;
			byte[] buf = new byte[1024];
			while((len=inputStream.read(buf))!=-1) {
				outputStream.write(buf, 0, len);
			}
			inputStream.close();
			return null;	
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
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

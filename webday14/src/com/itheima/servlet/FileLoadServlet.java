package com.itheima.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.print.attribute.ResolutionSyntax;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sun.misc.BASE64Encoder;


/**
 * Servlet implementation class FileLoadServlet
 */
public class FileLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�����ļ�����Ӣ�ĵ��ļ�
		//	downLoadFileNameForEnglish(request, response);
		
		
		String filename = request.getParameter("filename");
		filename = new String(filename.getBytes("ISO-8859-1"), "utf-8");
		
		System.out.println(filename);
		
		// �����ļ���InputStream.
		String realPath = this.getServletContext().getRealPath("onload/"+filename);
		System.out.println(realPath);
		FileInputStream inputStream = new FileInputStream(realPath);
		
		//����Content-Type
		String type = this.getServletContext().getMimeType(filename);
		response.setHeader("Content-Type", type);
		
		//��������������Ͳ��ò�ͬ���룬IE��Chrome���õ���URL���룬FireFox���õ���BASE64���롣
		String agent = request.getHeader("User-Agent");
		if (agent.contains("FireFox")) {
			filename = base64EncodeFileName(filename);
		}else {
			filename = URLEncoder.encode(filename, "utf-8");
		}
		
		// ����Content-Dispositionͷ ,�����filename��Ҫ����
		response.setHeader("Content-Disposition", "attachment;filename="+filename);
	

		// ���response�������:
		ServletOutputStream outputStream = response.getOutputStream();
		int len;
		byte[] buf = new byte[1024];
		while((len = inputStream.read(buf))!= -1) {
			outputStream.write(buf, 0, len);
			
		}
		inputStream.close();
		
	}
	
	/**
	 * ����������BASE64����
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

	
	/**
	 * �����ļ�����Ӣ�ĵ��ļ�
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void downLoadFileNameForEnglish(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String filename = request.getParameter("filename");
		//����Content-Type
		String type = this.getServletContext().getMimeType(filename);
		response.setHeader("Content-Type", type);
		// ����Content-Dispositionͷ
		response.setHeader("Content-Disposition", "attachment;filename="+filename);
		// �����ļ���InputStream.
//		String realPath = this.getServletContext().getRealPath("onload/"+filename);
//		System.out.println(realPath);
//		FileInputStream inputStream = new FileInputStream(realPath);
		
		InputStream inputStream = this.getServletContext().getResourceAsStream("onload/"+filename);

		// ���response�������:
		ServletOutputStream outputStream = response.getOutputStream();
		int len;
		byte[] buf = new byte[1024];
		while((len = inputStream.read(buf))!= -1) {
			outputStream.write(buf, 0, len);
		}
		inputStream.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

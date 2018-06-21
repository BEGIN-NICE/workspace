package com.itheima.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet response���ֽ������ַ�����ҳ��������Ӧ��
 */
public class OutPrintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�ֽ�Ӣ����ҳ�����
		//outputStream(response);
		//�ֽ����������
		//outputStreamForChinese(response);
		//�ַ�����ҳ�����
		//writerStream(response);
		//�ַ�����ҳ���������
		writerStreamForChinese(response);
	
	}

	private void writerStreamForChinese(HttpServletResponse response) throws IOException {
		//�����������ʱ����ַ�������
		response.setHeader("Content-Type", "text/html;charset=utf-8");
		
		//����response���������ַ�����
		response.setCharacterEncoding("utf-8");
		
		//��д
		//response.setContentType("text/html;charset=utf-8");
		response.getWriter().println("����");
		
	}

	/**
	 * �ַ�����ҳ�����
	 * @param response
	 * @throws IOException
	 */
	private void writerStream(HttpServletResponse response) throws IOException {
		response.getWriter().println("response getWriter");
		response.getWriter().write("response getWriter");
	}
	
	private void outputStreamForChinese(HttpServletResponse response) throws UnsupportedEncodingException, IOException {
		//�����������ʱ����õ��ַ�������
		response.setHeader("Content-Type", "text/html;charset=utf-8");
		
		//��������ת�ֽ������ʱ��ȡ���ı���
		response.getOutputStream().write("����".getBytes("utf-8"));
	}

	/**
	 * �ֽ�Ӣ����ҳ�����
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

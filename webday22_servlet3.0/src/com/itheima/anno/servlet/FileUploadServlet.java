package com.itheima.anno.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.coyote.http11.upgrade.UpgradeAprProcessor;
import org.apache.tomcat.util.http.fileupload.UploadContext;

import com.itheima.utils.UUIDUtil;
import com.itheima.utils.UploadUtil;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/FileUploadServlet")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//��ͨ���ݣ��е��ļ�����
		String filedesc = request.getParameter("filedesc");
		//��ȡ�ļ�����
		Part part = request.getPart("upload");
		//��ȡ�ļ���С
		long size = part.getSize();
		//��ȡ�ļ���(��ȡ���)
		String head = part.getHeader("Content-Disposition");
		int indexOf = head.lastIndexOf("filename=\"");
		String filename = head.substring(indexOf+10, head.length()-1);
		//���Ψһ�ļ�������Ч��ֹͬ���ļ����滻
		filename  = UUIDUtil.getFileName(filename);
		
		//�ļ�����Ŀ¼
		String path = UploadUtil.getPath(filename);
		
		//��ȡ�ļ�MIME����
		String header = part.getHeader("Content-Type");
		System.out.println("�ļ�MIME���ͣ�"+header);
		
		//����ϴ�
		String realPath = this.getServletContext().getRealPath("/load"+path);
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		InputStream inputStream = part.getInputStream();
		FileOutputStream outputStream = new FileOutputStream(realPath+"/"+filename);
		int len;
		byte[] buf = new byte[1024];
		while((len = inputStream.read(buf))!=-1) {
			outputStream.write(buf, 0, len);
		}
		outputStream.close();
		inputStream.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

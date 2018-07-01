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
		//普通数据，中的文件描述
		String filedesc = request.getParameter("filedesc");
		//获取文件部分
		Part part = request.getPart("upload");
		//获取文件大小
		long size = part.getSize();
		//获取文件名(截取获得)
		String head = part.getHeader("Content-Disposition");
		int indexOf = head.lastIndexOf("filename=\"");
		String filename = head.substring(indexOf+10, head.length()-1);
		//获得唯一文件名，有效防止同名文件的替换
		filename  = UUIDUtil.getFileName(filename);
		
		//文件所在目录
		String path = UploadUtil.getPath(filename);
		
		//获取文件MIME类型
		String header = part.getHeader("Content-Type");
		System.out.println("文件MIME类型："+header);
		
		//完成上传
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

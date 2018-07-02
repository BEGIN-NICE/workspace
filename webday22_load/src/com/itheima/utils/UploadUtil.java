package com.itheima.utils;

import javax.servlet.http.Part;

public class UploadUtil {
	//��ȡ�ϴ����ļ���
	public static String getFileName(Part part) {
		String header = part.getHeader("Content-Disposition");
		int lastIndexOf = header.lastIndexOf("filename=\"");
		String fileName = header.substring(lastIndexOf+10, header.length()-1);
		return fileName;
	}
	
	//��ȡ�ϴ��ļ���MIME����
	public static String getFileType(Part part) {
		String fileType = part.getHeader("Content-Type");
		return fileType;
	}
}

package com.itheima.utils;

import javax.servlet.http.Part;

public class UploadUtil {
	//获取上传的文件名
	public static String getFileName(Part part) {
		String header = part.getHeader("Content-Disposition");
		int lastIndexOf = header.lastIndexOf("filename=\"");
		String fileName = header.substring(lastIndexOf+10, header.length()-1);
		return fileName;
	}
	
	//获取上传文件的MIME类型
	public static String getFileType(Part part) {
		String fileType = part.getHeader("Content-Type");
		return fileType;
	}
}

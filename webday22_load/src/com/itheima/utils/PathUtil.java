package com.itheima.utils;

import javax.servlet.http.HttpServletRequest;

public class PathUtil {
	//根据目录分离算法，的到文件放置目录
	public static String getPath(String fileName) {
		StringBuilder sb = new StringBuilder();
		int code = fileName.hashCode();
		for (int i=0;i<2;i++) {
			int hashCode = code;
			int dir = hashCode & 0xf;
			sb.append("/").append(dir);
			code = code >>> 4;
		}
		return sb.toString();
	}
	
	public static String getDBPath(HttpServletRequest request,String path) {
		String contextPath = request.getContextPath();
		System.out.println(path);
		int indexOf = path.lastIndexOf("\\"+contextPath.substring(1));
		String dbPath = path.substring(indexOf);
		return dbPath;
	}
}

package com.itheima.utils;


/**
 * 使用算法创建文件夹
 * @author fanxh
 *
 */
public class UploadUtil {
	public static String getPath(String filename) {
		int code = filename.hashCode();
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<8 ;i++) {
			int d = code & 0xf;
			sb.append("/"+d);
			code = code >>> 4;
		}
//		int d1 = code1 & 0xf;
		return sb.toString();
	}
}

package com.itheima.utils;


/**
 * ʹ���㷨�����ļ���
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

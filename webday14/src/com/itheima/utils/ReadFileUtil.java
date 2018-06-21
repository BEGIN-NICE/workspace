package com.itheima.utils;

import java.io.IOException;
import java.io.InputStream;

public class ReadFileUtil {
	
	/**
	 * 1.类的加载器读取文件。
	 * 直接加载WEB-INF下的classes
	 * @throws IOException 
	 */
	public static void readFile() throws IOException {
		InputStream inputStream = ReadFileUtil.class.getClassLoader().getResourceAsStream("c3p0-config.xml");
		int len;
		byte[] buf = new byte[1024];
		while((len = inputStream.read(buf))!= -1) {
			System.out.println(new String(buf, 0, len));
		}
		inputStream.close();
	}
}

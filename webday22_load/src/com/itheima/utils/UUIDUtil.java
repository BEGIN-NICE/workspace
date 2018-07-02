package com.itheima.utils;

import java.util.UUID;

public class UUIDUtil {
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	//获得唯一文件名
	public static String getUUIDFileName(String fileName) {
		return UUIDUtil.getUUID()+"_"+fileName;
	}
}

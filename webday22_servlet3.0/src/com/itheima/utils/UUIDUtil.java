package com.itheima.utils;

import java.util.UUID;

public class UUIDUtil {
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	public static String getFileName(String filename) {
		return UUID.randomUUID().toString().replaceAll("-", "")+"_"+filename;
	}
}

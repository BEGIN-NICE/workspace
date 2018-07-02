package com.itheima.utils;

import java.util.UUID;

public class UUIDUtil {
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	//���Ψһ�ļ���
	public static String getUUIDFileName(String fileName) {
		return UUIDUtil.getUUID()+"_"+fileName;
	}
}

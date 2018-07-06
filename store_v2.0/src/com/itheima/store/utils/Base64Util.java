package com.itheima.store.utils;

import org.junit.Test;

import sun.misc.BASE64Encoder;

public class Base64Util {
	public static String getEncode(String str) {
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(str.getBytes());
	}
	
	@Test
	public void test() {
		String encode = Base64Util.getEncode("123123");
		System.out.println(encode);
		BASE64Encoder encoder = new BASE64Encoder();
		System.out.println(encoder.encode("123".getBytes()));
	}
}

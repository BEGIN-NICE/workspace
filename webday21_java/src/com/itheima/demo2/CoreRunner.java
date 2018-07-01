package com.itheima.demo2;

import java.lang.reflect.Method;

public class CoreRunner {
	
	public static void main(String[] args) throws Exception {
		Class clazz = Test.class;
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
		//	System.out.println(method.isAnnotationPresent(MyTest.class));
			if(method.isAnnotationPresent(MyTest.class)) {
				method.invoke(clazz.newInstance(),null);
			}
		}
	}
}

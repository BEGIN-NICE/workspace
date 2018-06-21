package com.itheima.day12;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class ClassTest {
	@Test
	public void methodTest() throws Exception {
		Class clazz = Class.forName("com.itheima.day12.Student");
		Constructor constructor = clazz.getConstructor();
		Student stu = (Student)constructor.newInstance();
		Method method = clazz.getDeclaredMethod("setName", String.class);
		method.setAccessible(true);
		method.invoke(stu, "ะกร๗");
		Method method2 = clazz.getDeclaredMethod("getName");
		method2.setAccessible(true);
		Object invoke = method2.invoke(stu);
		System.out.println(invoke);
		System.out.println(stu);
	}
}

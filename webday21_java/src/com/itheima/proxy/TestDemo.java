package com.itheima.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

public class TestDemo {

	@Test
	public void classLoadTest() {
		ClassLoader myLoad = TestDemo.class.getClassLoader();
		ClassLoader myLoad2 = Waitre.class.getClassLoader();
		
		ClassLoader jdkLoad = "String".getClass().getClassLoader();
		ClassLoader jdkLoad2 = String.class.getClassLoader();
		
		ClassLoader jdkLoad3 = Math.class.getClassLoader();
		System.out.println(myLoad);
		System.out.println(myLoad2);
		System.out.println(jdkLoad);
		System.out.println(jdkLoad2);
		System.out.println(jdkLoad3);
	}
	
	
	/**
	 * 测试动态代理
	 */
	@Test
	public void proxyTest() {
		Waitre waitre = new Waitress();
		Waitre waitre2 = (Waitre) Proxy.newProxyInstance(waitre.getClass().getClassLoader(), waitre.getClass().getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("invoke........");
				return method.invoke(waitre, args);
			}
		});
		waitre2.service();
		System.out.println(waitre2.sayHello("小明"));
	}
}

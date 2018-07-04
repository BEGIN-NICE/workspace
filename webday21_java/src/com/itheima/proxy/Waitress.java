package com.itheima.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

public class Waitress implements Waitre {

	@Override
	public void service() {
		System.out.println("service...........");

	}

	@Override
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		return "service......"+name;
	}
	
}

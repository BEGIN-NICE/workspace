package com.itheima.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyServletRequest implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("request������...........");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("request������................");
	}

}

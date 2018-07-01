package com.itheima.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener2 implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("servletcontext被创建了2................");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("servletcontext被销毁了2................");
	}
	
}

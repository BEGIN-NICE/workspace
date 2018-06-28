package com.itheima.listener;

import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		String name = (String) sce.getServletContext().getAttribute("fanxh");
		System.out.println(name);
		System.out.println("ServletContext������..........");
		 name = (String) sce.getServletContext().getAttribute("fanxh");
		System.out.println("after......"+name);
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		sce.getServletContext().setAttribute("fanxh", "fanxh");
		System.out.println("servletContext������..........");
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
			System.out.println("��ʱ������ʼִ��............");
			}
		}, 2000, 60000);
	}
	
}

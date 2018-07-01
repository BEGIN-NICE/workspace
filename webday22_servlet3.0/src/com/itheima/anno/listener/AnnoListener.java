package com.itheima.anno.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class AnnoListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("listener..........");

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("listenerdestroy...............");

	}

}

package com.itheima.sessionlistener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class MyHttpSessionBindingListener implements HttpSessionBindingListener {

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("javabean被绑定.............");
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("javabean被解除绑定.............");
	}

}

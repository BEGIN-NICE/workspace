package com.itheima.attributelistener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("sessionAttributeAdd...........");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("sessionAttributeRemoved...........");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("sessionAttributeReplaced...........");
	}

}

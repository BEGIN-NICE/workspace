package com.itheima.sessionlistener;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class MyHttpSessionActivationListener implements HttpSessionActivationListener {

	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("session被钝化(序列化)................");
	}

	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("session被活化(反序列化)................");
	}

}

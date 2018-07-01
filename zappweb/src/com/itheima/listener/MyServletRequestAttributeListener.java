package com.itheima.listener;

import java.util.Enumeration;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class MyServletRequestAttributeListener implements ServletRequestAttributeListener {

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
	
		System.out.println("ServletRequestAttributeReplaced222222222..........");
		Enumeration<String> en = srae.getServletRequest().getAttributeNames();
		System.out.println(en);
		while (en.hasMoreElements()) {
			String key = (String) en.nextElement();
			Object value = srae.getServletRequest().getAttribute(key);
			System.out.println("key="+key+"     value="+value);
			
		}
		System.out.println("================");
		System.out.println("name="+srae.getName()+"        value="+srae.getValue());
		System.out.println("Source=       "+srae.getSource());
		
	}

}

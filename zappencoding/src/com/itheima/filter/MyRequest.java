package com.itheima.filter;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyRequest extends HttpServletRequestWrapper {
	private HttpServletRequest request;
	private boolean encode;
	public MyRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	
	
	
	
	@Override
	public Map<String, String[]> getParameterMap() {
		String method = request.getMethod();
		if("post".equalsIgnoreCase(method)) {
			try {
				request.setCharacterEncoding("utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}else if("get".equalsIgnoreCase(method)) {
			if(!encode) {
				Map<String, String[]> map = request.getParameterMap();
				for (String str : map.keySet()) {
					for (String value : map.get(str)) {
						try {
							value = new String(value.getBytes("ISO-8859-1"),"UTF-8");
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				encode = !encode;
			}
		}
		return request.getParameterMap();
	}




	@Override
	public Enumeration<String> getParameterNames() {
		// TODO Auto-generated method stub
		return super.getParameterNames();
	}




	@Override
	public String[] getParameterValues(String name) {
		Map<String, String[]> map = request.getParameterMap();
		String[] strings = map.get(name);
		return strings;
	}




	@Override
	public String getParameter(String name) {
		String method = request.getMethod();
		if("get".equalsIgnoreCase(method)) {
			String value = name;
			try {
				value = new String(request.getParameter(name).getBytes("ISO-8859-1"),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return value;
		}else if("post".equalsIgnoreCase(method)) {
			try {
				request.setCharacterEncoding("utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return super.getParameter(name);
	}
	
	
}

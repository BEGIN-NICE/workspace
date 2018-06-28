package com.itheima.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LifeOfFilter implements Filter {

	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("doFilter..........");
		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init.............");
		String filterName = filterConfig.getFilterName();
		System.out.println("filterName= "+filterName);
		String username = filterConfig.getInitParameter("username");
		System.out.println("username= "+username);
		Enumeration<String> enumeration = filterConfig.getInitParameterNames();
		while (enumeration.hasMoreElements()) {
			String name = (String) enumeration.nextElement();
			String value = filterConfig.getInitParameter(name);
			System.out.println("name="+name+"  value="+value);
		}
	}

	@Override
	public void destroy() {
		System.out.println("destroy...............");
	}
	
	

}

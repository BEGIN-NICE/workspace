package com.itheima.anno.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import com.itheima.anno.MyHttpResponseWrapper;

@WebFilter(urlPatterns="/*",asyncSupported=true)
public class AnnoFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("createFilter................");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("filter_before...........");
		MyHttpResponseWrapper responseWrapper = new MyHttpResponseWrapper((HttpServletResponse) response);
		chain.doFilter(request, responseWrapper);
		System.out.println("filter_after...........");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}

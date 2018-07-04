package com.itheima.load.web.filter;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class GenericEncodingFilter
 */
@WebFilter("/*")
public class GenericEncodingFilter implements Filter {
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * 采用动态代理的方式完成通用字符集编码
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletRequest proreq = (HttpServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(),
				req.getClass().getInterfaces(), new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						if ("getParameter".equals(method.getName())) {
							if ("get".equalsIgnoreCase(req.getMethod())) {
								String value = (String) method.invoke(req, args);
								value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
								return value;

							} else if ("post".equalsIgnoreCase(req.getMethod())) {
								req.setCharacterEncoding("utf-8");
								return method.invoke(req, args);
							}
						}
						return method.invoke(req, args);
					}
				});
		chain.doFilter(proreq, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

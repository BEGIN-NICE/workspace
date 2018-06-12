package com.itheima.a_servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class demo02 implements Servlet {

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String sex = req.getParameter("sex");
		String city = req.getParameter("city");
		String[] hobby = req.getParameterValues("hobby");
		String discrete = req.getParameter("info");
		System.out.println(name);
		System.out.println(age);
		System.out.println(sex);
		System.out.println(city);
		System.out.println(Arrays.toString(hobby));
		System.out.println(discrete);
		res.setCharacterEncoding("GBK");
		res.getWriter().println(name);
		res.getWriter().println(age);
		res.getWriter().println(sex);
		res.getWriter().println(city);
		res.getWriter().println(Arrays.toString(hobby));
		res.getWriter().println(discrete);
		
	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}

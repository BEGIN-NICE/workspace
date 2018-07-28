package com.itheima.utils;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class BaseServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String method = request.getParameter("method");
			System.out.println(method);
			if (method == null) {
				request.setAttribute("msg", "方法名不存在");
			} else {
				Class clazz = this.getClass();
				Method method2 = clazz.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
				String path = (String) method2.invoke(this, request, response);
				if (path != null) {
					request.getRequestDispatcher(path).forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}

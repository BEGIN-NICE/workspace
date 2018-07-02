package com.itheima.store.web.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 字符集简单处理
			resp.setContentType("text/hmtl;charset=utf-8");
			req.setCharacterEncoding("utf-8");
			String methodStr = req.getParameter("method");
			if (methodStr == null || "".equals(methodStr)) {
				resp.getWriter().println("The name of method is error!!!");
				return;
			}
			Class class1 = this.getClass();
			Method method = class1.getMethod(methodStr, HttpServletRequest.class, HttpServletResponse.class);
			String path = (String) method.invoke(this, req, resp);
			if (path != null) {
				req.getRequestDispatcher(path).forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

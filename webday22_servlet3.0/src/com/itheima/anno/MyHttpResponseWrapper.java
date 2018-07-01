package com.itheima.anno;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class MyHttpResponseWrapper extends HttpServletResponseWrapper {
	
	private HttpServletResponse resposne;
	public MyHttpResponseWrapper(HttpServletResponse response) {
		super(response);
		this.resposne = response;
	}
	@Override
	public PrintWriter getWriter() throws IOException {
		resposne.setContentType("text/html;charset=utf-8");
		return super.getWriter();
	}
	
}

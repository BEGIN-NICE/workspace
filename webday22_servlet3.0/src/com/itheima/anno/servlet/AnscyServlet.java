package com.itheima.anno.servlet;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AnscyServlet
 */
@WebServlet(urlPatterns="/AnscyServlet",asyncSupported=true)
public class AnscyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AsyncContext context = request.startAsync(request, response);
		context.start(new MyRunnable(context));
		System.out.println(context);
//		new Thread(new MyRunnable(context)).start();
		for (int i = 0; i < 40; i++) {
			System.out.println(i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

class MyRunnable implements Runnable{
private AsyncContext context;
	public MyRunnable(AsyncContext context) {
		this.context = context;
	}
	
	@Override
	public void run() {
		for (char i = 'a'; i < 'z'; i++) {
			try {
				context.getResponse().getWriter().println(i);
//				Thread.sleep(200);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
}















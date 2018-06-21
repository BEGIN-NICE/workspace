package com.itheima.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.utils.FindCookie;

/**
 * Servlet implementation class CountServlet
 */
public class CountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html;charset=utf-8");
		Integer count = (Integer)this.getServletContext().getAttribute("count");
		Cookie[] cookies = request.getCookies();
		//���ü�¼�ϴε�¼ʱ���cookie��ΪlastVisit
		Cookie cookie = FindCookie.getCookie(cookies, "lastVisit");
//		for (Cookie c : cookies) {
//			System.out.println(c.getName()+"===="+c.getValue());
//		}
		if (cookie == null) {
			response.getWriter().println("���ǵ�"+count+"λ�����û�");
		}else {
			String value = cookie.getValue();
			long l = Long.parseLong(value);
			Date date = new Date(l);
			response.getWriter().println(count+"��ӭ���ã�����ϴη���ʱ���ǣ�"+date.toLocaleString());
		}
		
		Cookie cookie2 = new Cookie("lastVisit",""+System.currentTimeMillis());
		//����cookie����Ч·��
		cookie2.setPath("/webday15");
		//����cookie����Чʱ��
		cookie2.setMaxAge(60*60);//һСʱ
		response.addCookie(cookie2);
		response.getWriter().print("<h2><a href='/webday15/WEB01/product_list.jsp'>��Ʒ�б�</a></h2>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

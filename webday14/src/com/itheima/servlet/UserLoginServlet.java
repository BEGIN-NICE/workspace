package com.itheima.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.bean.User;
import com.itheima.sevice.UserLoginService;


/**
 * Servlet implementation class UserLoginServlet
 */
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����������
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				//��װ��ʵ�������
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				//����ҵ��㴦������
				UserLoginService userLoginService = new UserLoginService();
				User u = userLoginService.login(user);
				
				//�����ҳ��������ĵ��������⡣
//				response.setCharacterEncoding("GBK");
				response.setContentType("text/html;charset=UTF-8");
				//���ݷ��ؽ����ʾ��Ϣ
				if(u != null) {
					response.sendRedirect("/webday14/WEB01/success.html");
					
					//��¼�ض���λ�û���¼�ɹ�
//					response.getWriter().println("<h1>��ϲ��"+username+"   ��¼�ɹ�</h1>");
//					response.getWriter().println("<h1>ҳ�潫��3�����ת</h1>");
//					response.setHeader("Refresh", "3;url=/webday13/CountServlet");
					
				}else {
					response.getWriter().print("<h1>��¼ʧ��,�û��������벻����</h1>");
				}
				
				
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

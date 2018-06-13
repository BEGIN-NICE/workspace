package com.itheima.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.pojo.User;
import com.itheima.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init() throws ServletException {
		int count=0;
		this.getServletContext().setAttribute("count", count);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//��װ��ʵ�������
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		//����ҵ��㴦������
		UserService userService = new UserService();
		User u = userService.login(user);
		
		//�����ҳ��������ĵ��������⡣
//		response.setCharacterEncoding("GBK");
		response.setContentType("text/html;charset=UTF-8");
		//���ݷ��ؽ����ʾ��Ϣ
		if(u != null) {
			//��ת��ҳ
//			response.getWriter().println("<h1>��ϲ��"+username+"   ��¼�ɹ�</h1>");
//			response.getWriter().println("<h1>ҳ�潫��5�����ת</h1>");
//			response.setHeader("Refresh", "5;url=/webday13/WEB01/index.html");
			
			//ͨ��jsp�����ת������ʱ�䶯̬��ʾ
			response.setStatus(302);
			response.setHeader("Location", "/webday13/demo02-login/success.html");
			
			//��¼�ض���λ�û���¼�ɹ�
//			response.getWriter().println("<h1>��ϲ��"+username+"   ��¼�ɹ�</h1>");
//			response.getWriter().println("<h1>ҳ�潫��3�����ת</h1>");
//			response.setHeader("Refresh", "3;url=/webday13/CountServlet");
			
		}else {
			response.getWriter().print("<h1>��¼ʧ��,�û��������벻����</h1>");
		}
		
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

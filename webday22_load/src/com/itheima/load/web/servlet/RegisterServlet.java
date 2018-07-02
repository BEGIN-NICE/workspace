package com.itheima.load.web.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.itheima.load.domain.User;
import com.itheima.load.service.UserService;
import com.itheima.utils.PathUtil;
import com.itheima.utils.UUIDUtil;
import com.itheima.utils.UploadUtil;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
@MultipartConfig
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Part part = request.getPart("photo");
			String fileName = UploadUtil.getFileName(part);
			String uuidFileName = UUIDUtil.getUUIDFileName(fileName);
			User user = new User();
			user.setPassword(password);
			user.setUsername(username);
//			user.setPhotouuid(uuidFileName);
//			UserService userService = new UserService();
//			int status = userService.add(user);
//			if(status != 0) {
//				request.getSession().setAttribute("user", user);
//			}
			
			String path = PathUtil.getPath(uuidFileName);
			String realPath = this.getServletContext().getRealPath("/load"+path);
			File file = new File(realPath);
			if(!file.exists()) {
				file.mkdirs();
			}
			
			String dbPath = PathUtil.getDBPath(request, realPath);
			
			
			user.setPhotouuid(dbPath+"\\"+uuidFileName);
			UserService userService = new UserService();
			int status = userService.add(user);
			if(status != 0) {
				request.getSession().setAttribute("user", user);
			}
			
			
			InputStream inputStream = part.getInputStream();
			OutputStream outputStream = new FileOutputStream(realPath+"/"+uuidFileName);
			int len;
			byte[] buf = new byte[1024];
			while((len = inputStream.read(buf))!=-1) {
				outputStream.write(buf, 0, len);
			}
			outputStream.close();
			inputStream.close();
			
			response.sendRedirect(request.getContextPath()+"/first.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

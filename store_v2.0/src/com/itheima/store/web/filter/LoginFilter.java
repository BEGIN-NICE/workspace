package com.itheima.store.web.filter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.itheima.store.domain.User;
import com.itheima.store.service.UserService;
import com.itheima.store.service.impl.UserServiceImpl;
import com.itheima.store.utils.CookieUtil;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		User user = (User) req.getSession().getAttribute("user");
		if (user == null) {
			Cookie[] cookies = req.getCookies();
			//回写浏览记录
			Cookie cookie3 = CookieUtil.getCookie(cookies, "history");
			if(cookie3!= null) {
				String[] ids = cookie3.getValue().split("-");
				LinkedList<String> linkedList = new LinkedList<String>(Arrays.asList(ids));
				req.getSession().setAttribute("history", linkedList);
			}
			
			//回写用户名
			Cookie cookie2 = CookieUtil.getCookie(cookies, "remberUsername");
			if (cookie2 != null&&!"".equals(cookie2.getValue())) {
				req.getSession().setAttribute("remberUsername", cookie2.getValue());
			}
			
			//回写用户信息
			Cookie cookie = CookieUtil.getCookie(cookies, "autoUser");
			if (cookie != null && !"".equals(cookie.getValue())) {
				user = new User();
				user.setUsername(cookie.getValue().split("#")[0]);
				user.setPassword(cookie.getValue().split("#")[1]);
				UserService userService = new UserServiceImpl();
				try {
					user = userService.login(user);
					if (user != null) {
						req.getSession().setAttribute("user", user);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}/*else {
				req.getRequestDispatcher("/UserServlet?method=loginUI").forward(req, response);
				return;
			}*/
		}
		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}

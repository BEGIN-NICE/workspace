package com.itheima.load.web.filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.itheima.load.domain.User;
import com.itheima.load.service.UserService;
import com.itheima.utils.CookieUtil;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(urlPatterns="/*",dispatcherTypes= {DispatcherType.REQUEST,DispatcherType.FORWARD})
public class LoginFilter implements Filter {
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		User user = (User) req.getSession().getAttribute("user");
		if(user==null) {
			Cookie[] cookies = req.getCookies();
			Cookie cookie = CookieUtil.getCookie(cookies, "user");
			if(cookie == null) {
				chain.doFilter(request, response);
			}else {
				String value = cookie.getValue();
				User user2 = new User();
				user2.setUsername(value.split("#")[0]);
				user2.setPassword(value.split("#")[1]);
				UserService userService = new UserService();
				try {
					User existUser = userService.login(user);
					if(existUser != null) {
						req.getSession().setAttribute("user", existUser);
						chain.doFilter(request, response);
					}else {
						chain.doFilter(request, response);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

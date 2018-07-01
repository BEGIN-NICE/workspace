package com.itheima.auto.web.filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.itheima.auto.domain.User;
import com.itheima.auto.service.LoginService;
import com.itheima.utils.CookieUtil;

import sun.text.normalizer.UBiDiProps;

public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Filter开始执行了..............");
		HttpServletRequest req = (HttpServletRequest)request;
		if(req.getSession().getAttribute("existUser")!=null) {
			chain.doFilter(request, response);
		}else {
			Cookie[] cookies = req.getCookies();
			Cookie cookie = CookieUtil.findCookie(cookies, "existUser");
			if(cookie==null||"".equals(cookie.getValue())) {
				chain.doFilter(request, response);
			}else {
				try {
					String value = cookie.getValue();
					User user = new User();
					user.setUsername(value.split("#")[0]);
					user.setPassword(value.split("#")[1]);
					LoginService loginService = new LoginService();
					User login = loginService.login(user);
					if(login != null) {
						req.getSession().setAttribute("existUser", login);	
					}
					chain.doFilter(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
		System.out.println("Filter执行结束了..............");
	}

}

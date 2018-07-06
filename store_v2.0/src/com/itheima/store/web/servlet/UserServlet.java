package com.itheima.store.web.servlet;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import com.itheima.store.dao.UserDao;
import com.itheima.store.dao.impl.UserDaoImpl;
import com.itheima.store.domain.User;
import com.itheima.store.service.UserService;
import com.itheima.store.service.impl.UserServiceImpl;
import com.itheima.store.utils.BeanFactory;
import com.itheima.store.utils.MyDateConverter;
import com.itheima.store.utils.UUIDUtil;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

/*	*
	 * 1.转发到首页的的index方法
	 *
	public String index(HttpServletRequest req, HttpServletResponse resp) {
		return "/store/index.jsp";
	}*/

	// 转发到注册页面
	public String registerUI(HttpServletRequest req, HttpServletResponse resp) {
		return "/store/register.jsp";
	}

	// 校验注册用户的用户名是否存在
	public String checkUsername(HttpServletRequest req, HttpServletResponse resp) {
		try {
			String username = req.getParameter("username");
			UserService userService = (UserServiceImpl)BeanFactory.getBean("userServiceImpl");
			User existUser = userService.findByUsername(username);
			if (existUser == null) {
				resp.getWriter().println("1");
			} else {
				resp.getWriter().println("0");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 用户注册
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	public String save(HttpServletRequest req, HttpServletResponse resp) {
		try {
			//表单重复提交问题
			String token = (String) req.getSession().getAttribute("token");
			String token2 = req.getParameter("token");
			req.getSession().removeAttribute("token");
			if(token2.equals(token)) {			
				Map<String, String[]> map = req.getParameterMap();
				User user = new User();
				// 将字符串日期转为Date
				ConvertUtils.register(new MyDateConverter(), Date.class);
				BeanUtils.populate(user, map);
				System.out.println(user.getSex());
				// Date date = (Date) new MyDateConverter().convert(Date.class,
				// req.getParameter("birthday"));
				// user.setBirthday(date);
				user.setUid(UUIDUtil.getUUID());
				user.setCode(UUIDUtil.getUUID() + UUIDUtil.getUUID());
				user.setState(0);
				UserService userService = (UserServiceImpl)BeanFactory.getBean("userServiceImpl");
				userService.save(user);
				req.setAttribute("msg", "注册成功，请去邮箱激活！");
			}else {
				req.setAttribute("msg", "请不要重复提交！");
			}
				return "/store/message.jsp";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 用户激活
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	public String active(HttpServletRequest req, HttpServletResponse resp) {
		try {
			String code = req.getParameter("code");
			UserService userService = (UserServiceImpl)BeanFactory.getBean("userServiceImpl");
			User existUser = userService.findByCode(code);
			if (existUser != null) {
				existUser.setCode(null);
				existUser.setState(1);
				userService.update(existUser);
				req.setAttribute("msg", "激活成功");
			} else {
				req.setAttribute("msg", "激活失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/store/message.jsp";
	}

	
	public String loginUI(HttpServletRequest req, HttpServletResponse resp) {
		return "/store/login.jsp";
	}
	
	/**
	 * 用户登录的方法
	 */
	public String login(HttpServletRequest req, HttpServletResponse resp) {
		try {
			//验证码校验
			String code = req.getParameter("code");
			String code2 = (String) req.getSession().getAttribute("code");
			req.getSession().removeAttribute("code");
			if(!code2.equalsIgnoreCase(code)) {
				req.setAttribute("msg", "验证码错误");
				return "/store/login.jsp";
			}
			
			Map<String, String[]> map = req.getParameterMap();
			User user = new User();
			BeanUtils.populate(user, map);
			UserService userService = (UserServiceImpl)BeanFactory.getBean("userServiceImpl");
			User existUser = userService.login(user);
			if(existUser!=null) {
				//自动登录
				if("true".equals(req.getParameter("autologin"))) {
					Cookie cookie = new Cookie("autoUser", existUser.getUsername()+"#"+existUser.getPassword());
					cookie.setPath(req.getContextPath());
					cookie.setMaxAge(60*60*24*7);
					resp.addCookie(cookie);					
				}
				
				//记住密码
				if("true".equals(req.getParameter("remberusername"))) {
					Cookie cookie = new Cookie("remberUsername", existUser.getUsername());
					cookie.setPath(req.getContextPath());
					cookie.setMaxAge(60*60*24*7);
					resp.addCookie(cookie);
					req.getSession().setAttribute("remberUsername", existUser.getUsername());
				}
				
				req.getSession().setAttribute("user", existUser);
				resp.sendRedirect(req.getContextPath()+"/store");
				return null;
			}else {
				req.setAttribute("msg", "用户名或密码错误或未激活");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/store/login.jsp";
	}
	
	/**
	 * 用户退出的方法
	 */
	public String exit(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.getSession().removeAttribute("user");
			Cookie cookie = new Cookie("autoUser",null);
			cookie.setPath(req.getContextPath());
			cookie.setMaxAge(0);
			resp.addCookie(cookie);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/UserServlet?method=loginUI";
	}
	
	/**
	 * 用户清除浏览记录的方法
	 */
	public String clearHistory(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.getSession().removeAttribute("history");
			Cookie cookie = new Cookie("history",null);
			cookie.setPath(req.getContextPath());
			cookie.setMaxAge(0);
			resp.addCookie(cookie);	
			return "/ProductServlet?method=findByCid";
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}

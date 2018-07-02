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
import com.itheima.store.utils.MyDateConverter;
import com.itheima.store.utils.UUIDUtil;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 1.ת������ҳ�ĵ�index����
	 */
	public String index(HttpServletRequest req, HttpServletResponse resp) {
		return "/store/index.jsp";
	}

	// ת����ע��ҳ��
	public String registerUI(HttpServletRequest req, HttpServletResponse resp) {
		return "/store/register.jsp";
	}

	// У��ע���û����û����Ƿ����
	public String checkUsername(HttpServletRequest req, HttpServletResponse resp) {
		try {
			String username = req.getParameter("username");
			UserService userService = new UserServiceImpl();
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
	 * �û�ע��
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	public String save(HttpServletRequest req, HttpServletResponse resp) {
		try {
			Map<String, String[]> map = req.getParameterMap();
			User user = new User();
			// ���ַ�������תΪDate
			ConvertUtils.register(new MyDateConverter(), Date.class);
			BeanUtils.populate(user, map);
			// Date date = (Date) new MyDateConverter().convert(Date.class,
			// req.getParameter("birthday"));
			// user.setBirthday(date);
			user.setUid(UUIDUtil.getUUID());
			user.setCode(UUIDUtil.getUUID() + UUIDUtil.getUUID());
			user.setState(0);
			UserService userService = new UserServiceImpl();
			userService.save(user);
			req.setAttribute("msg", "ע��ɹ�����ȥ���伤�");
			return "/store/registerSuccess.jsp";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * �û�����
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	public String active(HttpServletRequest req, HttpServletResponse resp) {
		try {
			String code = req.getParameter("code");
			UserService userService = new UserServiceImpl();
			User existUser = userService.findByCode(code);
			if (existUser != null) {
				existUser.setCode(null);
				existUser.setState(1);
				userService.update(existUser);
				req.setAttribute("msg", "����ɹ�");
			} else {
				req.setAttribute("msg", "����ʧ��");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/store/registerSuccess.jsp";
	}

	
	public String loginUI(HttpServletRequest req, HttpServletResponse resp) {
		return "/store/login.jsp";
	}
	
	/**
	 * �û���¼�ķ���
	 */
	public String login(HttpServletRequest req, HttpServletResponse resp) {
		try {
			Map<String, String[]> map = req.getParameterMap();
			User user = new User();
			BeanUtils.populate(user, map);
			UserService userService = new UserServiceImpl();
			User existUser = userService.login(user);
			if(existUser!=null) {
				//�Զ���¼
				if("true".equals(req.getParameter("autologin"))) {
					Cookie cookie = new Cookie("autoUser", existUser.getUsername()+"#"+existUser.getPassword());
					cookie.setPath(req.getContextPath());
					cookie.setMaxAge(60*60*24*7);
					resp.addCookie(cookie);					
				}
				
				//��ס����
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
				req.setAttribute("msg", "�û�������������δ����");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/store/login.jsp";
	}
	
	/**
	 * �û��˳��ķ���
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
	
}

package com.demo.action;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.demo.domain.User;
import com.demo.service.UserService;
import com.demo.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("all")
@Namespace("/")
@ParentPackage("struts-default")
public class LoginAction extends ActionSupport implements ModelDriven<User> {
	private User user = new User();
	@Action(value="login",results={@Result(name="success",location="/showproduct.jsp"),@Result(name="failer",location="/login2.jsp")})
	public String execute() {
		UserService userService = new UserServiceImpl();
		try {
		User existUser = userService.findUser(user.getUsername(),user.getPassword());
		if(existUser!= null) {
			ServletActionContext.getRequest().getSession().setAttribute("user", existUser);
			return "success";
		}
		this.addActionError("用戶名或密碼不正确");
		return "failer";
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}

	@Override
	public User getModel() {
		
		return user;
	}
}

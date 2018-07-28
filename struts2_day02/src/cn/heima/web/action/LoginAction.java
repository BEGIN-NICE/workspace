package cn.heima.web.action;

import javax.swing.plaf.basic.BasicSliderUI.ActionScroller;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

import cn.heima.domain.User;

public class LoginAction extends ActionSupport implements ModelDriven<User>{
	private User user = new User();
	
	public String login() {
		if("tom".equals(user.getUsername())&&"123".equals(user.getPassword())) {
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
			return "success";
		}else {
			//传统struts2方法
			ValueStack valueStack = ActionContext.getContext().getValueStack();
			valueStack.set("loginmsg", "用户名或密码不正确");
			//struts2中，类继承actionsupport类后，提供了一些错误信息处理的方法
			this.addActionError("用户名或密码不正确");
			this.addFieldError("fieldName", "用户名或密码不存在");
			this.addActionMessage("用户名或密码不存在");
			return "failer";
		}
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
}

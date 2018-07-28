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
			//��ͳstruts2����
			ValueStack valueStack = ActionContext.getContext().getValueStack();
			valueStack.set("loginmsg", "�û��������벻��ȷ");
			//struts2�У���̳�actionsupport����ṩ��һЩ������Ϣ����ķ���
			this.addActionError("�û��������벻��ȷ");
			this.addFieldError("fieldName", "�û��������벻����");
			this.addActionMessage("�û��������벻����");
			return "failer";
		}
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
}

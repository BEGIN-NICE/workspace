package cn.heima.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

import cn.heima.domain.User;

public class ValueStackActionTest2 implements ModelDriven<User> {
	private User user = new User();
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	/**
	 * ��valuestack�д�ȡֵ�ò���
	 * @return
	 */
	public String execute() {
		user=new User();
		user.setUsername("fanxh");
		user.setPassword("123456");
		//��ȡValueStack����
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		return "success";
	}

}

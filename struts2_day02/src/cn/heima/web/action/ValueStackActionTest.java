package cn.heima.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

public class ValueStackActionTest {
	private String username = "fox";
	
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return "123";
	}

	/**
	 * ��valuestack�д�ȡֵ�ò���
	 * @return
	 */
	public String execute() {
		//��ȡValueStack����
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		valueStack.set("username", "setusername2");
		valueStack.push("ithiema");  //��root�д�����
		valueStack.set("name", "fanxh");//��root�д����ݣ��ײ���newһ��hashmap,Ȼ�����ݴ��ȥ
		
		return "success";
	}
}

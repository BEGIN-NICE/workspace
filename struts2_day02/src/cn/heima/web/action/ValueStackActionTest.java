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
	 * 往valuestack中存取值得测试
	 * @return
	 */
	public String execute() {
		//获取ValueStack对象
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		valueStack.set("username", "setusername2");
		valueStack.push("ithiema");  //往root中存数据
		valueStack.set("name", "fanxh");//往root中存数据，底层是new一个hashmap,然后将数据存进去
		
		return "success";
	}
}

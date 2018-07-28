package cn.heima.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import cn.heima.domain.User;
import cn.heima.web.action.ProductAction;

public class MyInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if(user != null) {
			return invocation.invoke();
		}else {
		ProductAction action = (ProductAction) invocation.getAction();
		action.addActionError("È¨ÏÞ²»×ã£¡£¡");
		return "login";
		}
	}

}

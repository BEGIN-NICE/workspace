package com.demo;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSONObject;
import com.demo.domain.Result;
import com.demo.domain.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		User user = (User) invocation.getInvocationContext().getSession().get("user");
		if(user == null) {
			Result<Object> result = new Result<>();
			result.setType(0);
			result.setMessage("权限不足，请先登录！");
			String json = JSONObject.toJSONString(result);
			ServletActionContext.getResponse().setCharacterEncoding("utf-8");
			ServletActionContext.getResponse().getWriter().println(json);
			return null;
		}
		return invocation.invoke();
	}
	
}

package com.itheima.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.itheima.domain.Result;
import com.opensymphony.xwork2.ActionSupport;

public class CheckAction extends ActionSupport{
	
	public void checkUsername() throws Exception{
		String username = ServletActionContext.getRequest().getParameter("username");
		Result result = new Result();
		
		if("tom".equals(username)) {
			result.setFlag(false);
			result.setMessage("用户名已被占用");
		}else if ("".equals(username)) {
			result.setFlag(false);
			result.setMessage("用户名不能为空");
		}else {
			result.setFlag(true);
			result.setMessage("用户名可以使用");
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String str = mapper.writeValueAsString(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.getWriter().println(str);
		
	}
}

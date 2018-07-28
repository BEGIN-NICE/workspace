package cn.heima.web.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 获取valuestack 的两种方法
 * @author fanxh
 *
 */
public class ValueStackAction extends ActionSupport implements RequestAware{
	private Map<String, Object> request;
	public String execute() {
//		//方式一：从request对象中国获取
//		HttpServletRequest request = ServletActionContext.getRequest();
//		ValueStack valuestack = (ValueStack) request.getAttribute(ServletActionContext.STRUTS_VALUESTACK_KEY);
//		
//		//方式二：通过ActionContext对象获取，因为valuestack是线程绑定的
//		ActionContext context = ActionContext.getContext();
//		ValueStack stack = context.getValueStack();
		HttpServletRequest request = ServletActionContext.getRequest();
		ValueStack valuestack = (ValueStack) request.getAttribute(ServletActionContext.STRUTS_VALUESTACK_KEY);
		System.out.println(valuestack);
		ValueStack valuestack1 = (ValueStack) ServletActionContext.getContext().get(ServletActionContext.STRUTS_VALUESTACK_KEY);
		System.out.println(valuestack1);
		//方式二：通过ActionContext对象获取，因为valuestack是线程绑定的
		ActionContext context = ActionContext.getContext();
		ValueStack stack = context.getValueStack();
		System.out.println(stack);
		ValueStack valuestack2 = (ValueStack) request.getAttribute(ServletActionContext.STRUTS_VALUESTACK_KEY);
		System.out.println(valuestack2);
		return "success";
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request=request;
	}
}

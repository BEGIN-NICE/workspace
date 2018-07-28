package cn.heima.test;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.junit.Test;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

public class ValueStackTest {
	@Test
	public void test1() {
		HttpServletRequest request = ServletActionContext.getRequest();
		ValueStack valuestack = (ValueStack) request.getAttribute(ServletActionContext.STRUTS_VALUESTACK_KEY);
		System.out.println(valuestack);
		ValueStack valuestack1 = (ValueStack) ServletActionContext.getContext().get(ServletActionContext.STRUTS_VALUESTACK_KEY);
		System.out.println(valuestack1);
		//方式二：通过ActionContext对象获取，因为valuestack是线程绑定的
		ActionContext context = ActionContext.getContext();
		ValueStack stack = context.getValueStack();
		System.out.println(stack);
	}
}

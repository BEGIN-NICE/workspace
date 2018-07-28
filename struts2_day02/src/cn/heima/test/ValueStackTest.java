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
		//��ʽ����ͨ��ActionContext�����ȡ����Ϊvaluestack���̰߳󶨵�
		ActionContext context = ActionContext.getContext();
		ValueStack stack = context.getValueStack();
		System.out.println(stack);
	}
}

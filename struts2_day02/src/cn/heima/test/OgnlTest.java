package cn.heima.test;

import java.util.HashMap;

import org.junit.Test;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

/**
 * ognl���ʽ�Ĳ���
 * @author fanxh
 *
 */
public class OgnlTest {
	/**
	 * ognl��������
	 * @throws OgnlException
	 */
	@Test
	public void ognltest1() throws OgnlException {
		//��ȡOGNLContext������
		OgnlContext context = new OgnlContext();//������һ��java.util.Map
		//��ȡ��Ŀ¼
		Object root = context.getRoot();
		//��������
		Object value = Ognl.getValue("'abcdtest'.length()", context, root);
		System.out.println(value);
		
	}
	/**
	 * ognl������̬����
	 * @throws OgnlException
	 */
	@Test
	public void ognltest2() throws OgnlException {
		//��ȡOGNLContext������
		OgnlContext context = new OgnlContext();
		//��ȡ��Ŀ¼
		Object root = context.getRoot();
		//��������
		Object value = Ognl.getValue("@java.lang.Math@random()", context, root);
		Object value2 = Ognl.getValue("@java.lang.Math@PI", context, root);
		System.out.println(value);
		System.out.println(value2);
		
	}
	/**
	 * ognl�����洢����
	 * @throws OgnlException
	 */
	@Test
	public void ognltest3() throws OgnlException {
		//��ȡOGNLContext������
		OgnlContext context = new OgnlContext();
		//��ȡ��Ŀ¼
		Object root = context.getRoot();
		//��context�д洢����
		context.put("username", "tom");
		//����
		Object value = Ognl.getValue("#username", context, root);
		System.out.println(value);
		
	}
	
	/**
	 * ognl�����洢��root������
	 * @throws OgnlException
	 */
	@Test
	public void ognltest4() throws OgnlException {
		//��ȡOGNLContext������
		OgnlContext context = new OgnlContext();
		//��ȡ��Ŀ¼
		HashMap<String, String> map = new HashMap<>();
		map.put("username", "tomroot");
		context.setRoot(map);
		Object root = context.getRoot();
		//��context�д洢����
		context.put("username", "tom");
		//����
		Object value = Ognl.getValue("#username", context, root);
		Object value2 = Ognl.getValue("username", context, root);
		System.out.println("��#....."+value);
		System.out.println("����#......."+value2);
		
	}
}

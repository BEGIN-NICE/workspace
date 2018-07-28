package cn.heima.test;

import java.util.HashMap;

import org.junit.Test;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

/**
 * ognl表达式的测试
 * @author fanxh
 *
 */
public class OgnlTest {
	/**
	 * ognl操作对象
	 * @throws OgnlException
	 */
	@Test
	public void ognltest1() throws OgnlException {
		//获取OGNLContext上下文
		OgnlContext context = new OgnlContext();//它就是一个java.util.Map
		//获取根目录
		Object root = context.getRoot();
		//操作对象
		Object value = Ognl.getValue("'abcdtest'.length()", context, root);
		System.out.println(value);
		
	}
	/**
	 * ognl操作静态方法
	 * @throws OgnlException
	 */
	@Test
	public void ognltest2() throws OgnlException {
		//获取OGNLContext上下文
		OgnlContext context = new OgnlContext();
		//获取根目录
		Object root = context.getRoot();
		//操作对象
		Object value = Ognl.getValue("@java.lang.Math@random()", context, root);
		Object value2 = Ognl.getValue("@java.lang.Math@PI", context, root);
		System.out.println(value);
		System.out.println(value2);
		
	}
	/**
	 * ognl操作存储数据
	 * @throws OgnlException
	 */
	@Test
	public void ognltest3() throws OgnlException {
		//获取OGNLContext上下文
		OgnlContext context = new OgnlContext();
		//获取根目录
		Object root = context.getRoot();
		//向context中存储数据
		context.put("username", "tom");
		//操作
		Object value = Ognl.getValue("#username", context, root);
		System.out.println(value);
		
	}
	
	/**
	 * ognl操作存储在root中数据
	 * @throws OgnlException
	 */
	@Test
	public void ognltest4() throws OgnlException {
		//获取OGNLContext上下文
		OgnlContext context = new OgnlContext();
		//获取根目录
		HashMap<String, String> map = new HashMap<>();
		map.put("username", "tomroot");
		context.setRoot(map);
		Object root = context.getRoot();
		//向context中存储数据
		context.put("username", "tom");
		//操作
		Object value = Ognl.getValue("#username", context, root);
		Object value2 = Ognl.getValue("username", context, root);
		System.out.println("带#....."+value);
		System.out.println("不带#......."+value2);
		
	}
}

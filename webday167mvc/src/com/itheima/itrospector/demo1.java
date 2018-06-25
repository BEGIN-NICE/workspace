package com.itheima.itrospector;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.catalina.util.Introspection;
import org.junit.Test;

import com.itheima.domain.User;

/**
 * 对内省进行测试
 * @author fanxh
 *
 */
public class demo1 {
	@Test
	public void test1() throws Exception {
		Class<User> clazz = (Class<User>) Class.forName("com.itheima.domain.User");
		Constructor<User> constructor = clazz.getConstructor(String.class,String.class);
		User user = constructor.newInstance("fanxh","123");
		BeanInfo beanInfo = Introspector.getBeanInfo(User.class);
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor pd : pds) {
			//获取User类中的所有属性名
			System.out.println(pd.getName());
			//获取属性的类型
			System.out.println(pd.getPropertyType());
			//
			Method method = pd.getReadMethod();
			
			System.out.println(method.invoke(user));
		}
	}
}

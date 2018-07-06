package com.itheima.store.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class BeanFactory {
	public static Object getBean(String id) {
		try {
			SAXReader saxReader = new SAXReader();
			Document read = saxReader.read(BeanFactory.class.getClassLoader().getResourceAsStream("applicationContext.xml"));
			Element node = (Element) read.selectSingleNode("//bean[@id='"+id+"']");
			String value = node.attributeValue("class");
			Class clazz = Class.forName(value);
			return clazz.newInstance();
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	@Test
	public void test() {
		try {
			BeanFactory.getBean("userServlet");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package com.itheima.parse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class XMLTest {
	@Test
	public void xmlTest1() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read("XML/fan.xml");
		Element rootElement = document.getRootElement();
		System.out.println(rootElement);
		Element pelement = rootElement.element("person");
		Element nelement = pelement.element("name");
		Element aelement = pelement.element("age");
		Element selement = pelement.element("sex");
		System.out.println(nelement.getText());
		System.out.println(aelement.getText());
		System.out.println(selement.getText());
	}
}

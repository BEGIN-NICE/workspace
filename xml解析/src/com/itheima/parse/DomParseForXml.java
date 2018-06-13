package com.itheima.parse;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomParseForXml {
	/**
	 * Dom解析
	 */
	@Test
	public void domXmlParse() {
		// 创建解析器工厂
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// 由工厂创建一个DocumentBuilder解析器
		try {
		DocumentBuilder db = factory.newDocumentBuilder();
		// 创建一个Document对象
		Document doc = (Document) db.parse("XML/student.xml");
		// 获取所有节点
		NodeList nodes = ((Node) doc).getChildNodes();
		// 获取根节点
		Node root = nodes.item(0);
		System.out.println(root.getNodeName());
		// 获取根节点的所有子节点
		NodeList students = root.getChildNodes();
		for (int i = 0; i < students.getLength(); i++) {
		// 遍历获得根节点的子节点
		Node student = students.item(i);
		// 获得根节点下子节点的所有子节点
		NodeList texts = student.getChildNodes();
		for (int j = 0; j < texts.getLength(); j++) {
		// 遍历根节点下子节点的子节点,并输出其文本内容
		Node text = texts.item(j);
		if (text.getNodeName().equals("stuno")) {
		System.out.println("学号：" + text.getTextContent());
		} else if (text.getNodeName().equals("name")) {
		System.out.println("姓名:" + text.getTextContent());
		} else if (text.getNodeName().equals("sex")) {
		System.out.println("性别:" + text.getTextContent());
		} else if (text.getNodeName().equals("grade")) {
		System.out.println("班级:" + text.getTextContent());
		}
		}

		}
		} catch (ParserConfigurationException | SAXException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
}

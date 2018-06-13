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
	 * Dom����
	 */
	@Test
	public void domXmlParse() {
		// ��������������
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// �ɹ�������һ��DocumentBuilder������
		try {
		DocumentBuilder db = factory.newDocumentBuilder();
		// ����һ��Document����
		Document doc = (Document) db.parse("XML/student.xml");
		// ��ȡ���нڵ�
		NodeList nodes = ((Node) doc).getChildNodes();
		// ��ȡ���ڵ�
		Node root = nodes.item(0);
		System.out.println(root.getNodeName());
		// ��ȡ���ڵ�������ӽڵ�
		NodeList students = root.getChildNodes();
		for (int i = 0; i < students.getLength(); i++) {
		// ������ø��ڵ���ӽڵ�
		Node student = students.item(i);
		// ��ø��ڵ����ӽڵ�������ӽڵ�
		NodeList texts = student.getChildNodes();
		for (int j = 0; j < texts.getLength(); j++) {
		// �������ڵ����ӽڵ���ӽڵ�,��������ı�����
		Node text = texts.item(j);
		if (text.getNodeName().equals("stuno")) {
		System.out.println("ѧ�ţ�" + text.getTextContent());
		} else if (text.getNodeName().equals("name")) {
		System.out.println("����:" + text.getTextContent());
		} else if (text.getNodeName().equals("sex")) {
		System.out.println("�Ա�:" + text.getTextContent());
		} else if (text.getNodeName().equals("grade")) {
		System.out.println("�༶:" + text.getTextContent());
		}
		}

		}
		} catch (ParserConfigurationException | SAXException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
}

package com.itheima.store.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * ע�ᷢ���ʼ�
 * @author fanxh
 *
 */
public class MailUtil {
	public static void sendMail(String to,String code) {
		try {
		//1.�����������
			//�������ԣ���дĬ��Ϊ����
			Properties props = new Properties();
			Session session = Session.getDefaultInstance(props, new Authenticator() {
	
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					
					return new PasswordAuthentication("service@store.com", "123");
				}	
			});
			
		//2.�����ʼ�
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("service@store.com"));
			//�����ռ���
			//TO:�ռ���(���Կ������ͣ�����������)     CC:����   		BCC:���ͣ�����
			message.addRecipient(RecipientType.TO, new InternetAddress(to));
			//����
			message.setSubject("���Ժ���ٷ��̳ǵļ����ʼ���");
			//����
			message.setContent("<h1>���Թ������ú���ٷ��̳ǵļ����ʼ�:�����������Ӽ��</h1><h3><a href='http://localhost:8080/store_v2.0/UserServlet?method=active&code="+code+"'>http://localhost:8080/store_v2.0/"+code+"</a></h3>", "text/html;charset=utf-8");
		//3.�����ʼ�
			Transport.send(message);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
}

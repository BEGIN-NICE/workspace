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
 * 注册发送邮件
 * @author fanxh
 *
 */
public class MailUtil {
	public static void sendMail(String to,String code) {
		try {
		//1.获得邮箱链接
			//设置属性，不写默认为本地
			Properties props = new Properties();
			Session session = Session.getDefaultInstance(props, new Authenticator() {
	
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					
					return new PasswordAuthentication("service@store.com", "123");
				}	
			});
			
		//2.构建邮件
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("service@store.com"));
			//设置收件人
			//TO:收件人(可以看到抄送，看不到密送)     CC:抄送   		BCC:暗送，密送
			message.addRecipient(RecipientType.TO, new InternetAddress(to));
			//主题
			message.setSubject("来自黑马官方商城的激活邮件！");
			//正文
			message.setContent("<h1>来自购物天堂黑马官方商城的激活邮件:请点击下面链接激活！</h1><h3><a href='http://localhost:8080/store_v2.0/UserServlet?method=active&code="+code+"'>http://localhost:8080/store_v2.0/"+code+"</a></h3>", "text/html;charset=utf-8");
		//3.发送邮件
			Transport.send(message);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
}

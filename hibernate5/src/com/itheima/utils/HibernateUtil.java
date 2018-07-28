package com.itheima.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static Configuration cfg ;
	private static SessionFactory sf;
	static {
		//����src�µ�hibernate.cfg.xml�ļ�
		cfg = new Configuration().configure();
		//cfg = new Configuration(); //����src�µ�hibernate.properties�ļ�
		sf = cfg.buildSessionFactory();
	}
	
	public static Session getSession() {
		return sf.openSession();
	}
}

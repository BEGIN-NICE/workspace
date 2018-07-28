package com.itheima.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static Configuration cfg ;
	private static SessionFactory sf;
	static {
		//加载src下的hibernate.cfg.xml文件
		cfg = new Configuration().configure();
		//cfg = new Configuration(); //加载src下的hibernate.properties文件
		sf = cfg.buildSessionFactory();
	}
	
	public static Session getSession() {
		return sf.openSession();
	}
}

package com.itheima.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static Configuration cfg;
	private static SessionFactory sf;
	static {
		cfg = new Configuration().configure();
		sf = cfg.buildSessionFactory();
	}
	
	public static Session openSession() {
		return sf.openSession();
	}
}

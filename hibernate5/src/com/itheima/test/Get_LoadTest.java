package com.itheima.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.domain.User;
import com.itheima.utils.HibernateUtil;

public class Get_LoadTest {
	/**
	 * ²âÊÔget/loadµÄÇø±ð
	 */
	@Test
	public void test() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		User load = session.load(User.class, 1);
		System.out.println(load.getClass());
		
		User user = session.get(User.class, 1);
		System.out.println(user.getClass());
		
		tx.commit();
		session.close();
	}
}

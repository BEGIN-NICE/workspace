package com.itheima.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.annotation.onetoone.IDCard;
import com.itheima.annotation.onetoone.User;
import com.itheima.utils.HibernateUtil;

public class DoubleOneToOneTest {
	@Test
	public void oneToOneTest() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		User user = session.get(User.class, 2);
		System.out.println(user.getName()+"       "+user.getIdCard().getCardNum());
		System.out.println("---------------------");
		IDCard idCard = session.get(IDCard.class, 2);
		System.out.println(idCard.getCardNum()+"-----------"+idCard.getUser().getName());
		
		tx.commit();
		session.close();
	}
}

package com.itheima.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.all_2_onetoone.Husband;
import com.itheima.all_2_onetoone.IDCard;
import com.itheima.all_2_onetoone.User;
import com.itheima.all_2_onetoone.Wife;
import com.itheima.utils.HibernateUtil;

public class All_2_OneToOneTest {
	@Test
	public void test2_get_primary_key() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Husband husband = session.get(Husband.class, "4028c28664f085d40164f085da2b0000");
		System.out.println(husband.getName()+"===="+husband.getWife().getName());
		
		tx.commit();
		session.close();
		
	}
	@Test
	public void test_prepare_primary_key() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Wife wife = new Wife();
		wife.setName("wife");
		Husband husband = new Husband();
		husband.setName("husband");
		husband.setWife(wife);
		session.save(husband);
		tx.commit();
		session.close();
		
	}
	
	
	/**
	 * 基于外键
	 */
	@Test
	public void test2_get() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		User user = session.get(User.class, 1);
		System.out.println(user.getName()+"===="+user.getIdCard().getCardNum());
		
		tx.commit();
		session.close();
		
	}
	@Test
	public void test_prepare() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		User user = new User();
		user.setName("周瑜");
		IDCard idCard = new IDCard();
		idCard.setCardNum("123456789");
		idCard.setUser(user);
		
		session.save(idCard);
		tx.commit();
		session.close();
		
	}
}

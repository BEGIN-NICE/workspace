package com.itheima.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.all_1.Customer;
import com.itheima.utils.HibernateUtil;

public class All_1_Test {
	
	
	@Test
	public void test4_delete() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer c = session.get(Customer.class, 1);
		session.delete(c);
		
		tx.commit();
		session.close();
	}
	
	@Test
	public void test3_query() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
//		List<Customer> list = session.createQuery("from Customer").list();
//		System.out.println(list);
		Customer c = (Customer) session.createQuery("from Customer").uniqueResult();
		System.out.println(c);
		
		tx.commit();
		session.close();
	}
	
	@Test
	public void test2_update() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer c = session.get(Customer.class, 1);
		c.setName("»Æ¸Ç");
		
		session.update(c);
		
		tx.commit();
		session.close();
	}
	
	@Test
	public void test1_save() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer c = new Customer();
		c.setAddr("ÄÏ¾©");
		c.setName("ÖÜè¤");
		
		session.save(c);
		
		tx.commit();
		session.close();
	}
}

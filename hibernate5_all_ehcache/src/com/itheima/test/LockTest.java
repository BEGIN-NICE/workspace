package com.itheima.test;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.domain.Book;
import com.itheima.domain.Catregory;
import com.itheima.utils.HibernateUtil;

/**
 * Book¿‡≤‚ ‘±Øπ€À¯
 * Catregory¿‡≤‚ ‘¿÷π€À¯
 * @author fanxh
 *
 */
public class LockTest {
	@Test
	public void test4_Optimistic_lock() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		Catregory c = session.get(Catregory.class, 5);
		c.setName("–¸“…");
		session.save(c);
		
		tx.commit();
		session.close();
	}
	
	@Test
	public void test3_Optimistic_lock() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		Catregory c = session.get(Catregory.class, 5);
		c.setName("–¸“…1");
		session.save(c);
		
		tx.commit();
		session.close();
	}
	
	@Test
	public void test2_pessimistic_lock() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		Book book2 = session.get(Book.class, 1, LockMode.READ);
		System.out.println(book2);
		
		tx.commit();
		session.close();
	}
	
	
	@Test
	public void test_pessimistic_lock() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		Book book = session.get(Book.class, 1, LockMode.READ);
		System.out.println(book);
		
		
		tx.commit();
		session.close();
	}
}

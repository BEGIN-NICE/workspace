package com.itheima.test;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.domain.Customer;
import com.itheima.utils.HibernateUtil;

public class SetFetchTest {

	/**
	 * set上的fetch=subselect
	 */
	@Test
	public void test2() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		List<Customer> list = session.createQuery("from Customer").list();
		for (Customer c : list) {
			System.out.println(c.getOrders().size());
		}
		
		tx.commit();
		session.close();
	}
	
	/**
	 * set上的fetch=select，lazy=true，false，extra
	 */
	@Test
	public void test1() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Customer c = session.get(Customer.class, 1);
		int size = c.getOrders().size();
		System.out.println(size);
		tx.commit();
		session.close();
	}
}

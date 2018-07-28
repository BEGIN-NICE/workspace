package com.itheima.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.one_to_many.Customer;
import com.itheima.one_to_many.Order;
import com.itheima.utils.HibernateUtil;

public class One_to_Many_Test {
	
	/**
	 * 测试数据保存,
	 */
	@Test
	public void saveTest4() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Order o1 = new Order();
		o1.setMoney(500d);
		o1.setReceiverInfo("北京");
		Order o2 = new Order();
		o2.setMoney(550d);
		o2.setReceiverInfo("上海");
		
		Customer c = new Customer();
		c.setName("袁绍2");
		
		c.getOrders().add(o1);
		c.getOrders().add(o2);
		
		session.save(c);

		
		tx.commit();
		session.close();
	}
	
	
	/**
	 * 测试一对多的数据保存,
	 * 只保存一的一方，多的一方自动保存(一的一方设置级联)
	 */
	@Test
	public void saveTest3() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Order o1 = new Order();
		o1.setMoney(500d);
		o1.setReceiverInfo("北京");
		Order o2 = new Order();
		o2.setMoney(550d);
		o2.setReceiverInfo("上海");
		
		Customer c = new Customer();
		c.setName("袁绍2");
		
		c.getOrders().add(o1);
		c.getOrders().add(o2);
		
		session.save(c);

		
		tx.commit();
		session.close();
	}
	
	/**
	 * 测试一对多的数据保存,只保存多的一方，一的一方自动保存(多的一方设置级联)
	 */
	@Test
	public void saveTest2() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Order o1 = new Order();
		o1.setMoney(500d);
		o1.setReceiverInfo("北京");
		Order o2 = new Order();
		o2.setMoney(550d);
		o2.setReceiverInfo("上海");
		
		Customer c = new Customer();
		c.setName("袁绍");
		
		o1.setC(c);
		o2.setC(c);
		
		session.save(o1);
		session.save(o2);
		
		
		tx.commit();
		session.close();
	}
	
	/**
	 * 测试一对多的数据保存(没有级联)
	 */
	@Test
	public void saveTest() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Order o1 = new Order();
		o1.setMoney(500d);
		o1.setReceiverInfo("北京");
		Order o2 = new Order();
		o2.setMoney(550d);
		o2.setReceiverInfo("上海");
		
		Customer c = new Customer();
		c.setName("袁绍");
		
		o1.setC(c);
		o2.setC(c);
		
		c.getOrders().add(o1);
		c.getOrders().add(o2);
		
		session.save(o1);
		session.save(o2);
		session.save(c);
		
		tx.commit();
		session.close();
	}
}

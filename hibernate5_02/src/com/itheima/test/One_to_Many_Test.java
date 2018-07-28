package com.itheima.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.one_to_many.Customer;
import com.itheima.one_to_many.Order;
import com.itheima.utils.HibernateUtil;

public class One_to_Many_Test {
	
	/**
	 * �������ݱ���,
	 */
	@Test
	public void saveTest4() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Order o1 = new Order();
		o1.setMoney(500d);
		o1.setReceiverInfo("����");
		Order o2 = new Order();
		o2.setMoney(550d);
		o2.setReceiverInfo("�Ϻ�");
		
		Customer c = new Customer();
		c.setName("Ԭ��2");
		
		c.getOrders().add(o1);
		c.getOrders().add(o2);
		
		session.save(c);

		
		tx.commit();
		session.close();
	}
	
	
	/**
	 * ����һ�Զ�����ݱ���,
	 * ֻ����һ��һ�������һ���Զ�����(һ��һ�����ü���)
	 */
	@Test
	public void saveTest3() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Order o1 = new Order();
		o1.setMoney(500d);
		o1.setReceiverInfo("����");
		Order o2 = new Order();
		o2.setMoney(550d);
		o2.setReceiverInfo("�Ϻ�");
		
		Customer c = new Customer();
		c.setName("Ԭ��2");
		
		c.getOrders().add(o1);
		c.getOrders().add(o2);
		
		session.save(c);

		
		tx.commit();
		session.close();
	}
	
	/**
	 * ����һ�Զ�����ݱ���,ֻ������һ����һ��һ���Զ�����(���һ�����ü���)
	 */
	@Test
	public void saveTest2() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Order o1 = new Order();
		o1.setMoney(500d);
		o1.setReceiverInfo("����");
		Order o2 = new Order();
		o2.setMoney(550d);
		o2.setReceiverInfo("�Ϻ�");
		
		Customer c = new Customer();
		c.setName("Ԭ��");
		
		o1.setC(c);
		o2.setC(c);
		
		session.save(o1);
		session.save(o2);
		
		
		tx.commit();
		session.close();
	}
	
	/**
	 * ����һ�Զ�����ݱ���(û�м���)
	 */
	@Test
	public void saveTest() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Order o1 = new Order();
		o1.setMoney(500d);
		o1.setReceiverInfo("����");
		Order o2 = new Order();
		o2.setMoney(550d);
		o2.setReceiverInfo("�Ϻ�");
		
		Customer c = new Customer();
		c.setName("Ԭ��");
		
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

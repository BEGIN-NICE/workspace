package com.itheima.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.all_1.Customer;
import com.itheima.utils.HibernateUtil;

public class All_1_Test {
	
	/**
	 * �־û����������״̬
	 */
	@Test
	public void test6_object_status2() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();

//		Customer c = session.get(Customer.class, 4);//�־�̬
		Customer c = session.load(Customer.class, 6);//�־�̬
		System.out.println(c.getClass());
		session.delete(c);
//		System.out.println(c.getName());
		
		tx.commit();
		session.close();
		System.out.println(c.getName());//�й�̬
	}
	
	
	/**
	 * �־û����������״̬
	 */
	@Test
	public void test6_object_status() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer c = new Customer();//˲ʱ̬
		c.setAddr("�Ͼ�");
		c.setName("���»�");
		
		session.save(c);//�־�̬ �����ʱ���c��OId
		
		tx.commit();
		session.close();
		System.out.println(c.getId());//�й�̬
	}
	
	
	
	/**
	 *get��ʽ��ѯ���ݣ�������ݿ���û�����᷵��null
	 */
	@Test
	public void test5_get() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer c = session.get(Customer.class, 100);
		System.out.println(c);
		
		tx.commit();
		session.close();
	}
	
	
	
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
		c.setName("�Ƹ�");
		
		session.update(c);
		
		tx.commit();
		session.close();
	}
	
	@Test
	public void test1_save() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer c = new Customer();
		c.setAddr("�Ͼ�");
		c.setName("���");
		
		session.save(c);
		
		tx.commit();
		session.close();
	}
}

package com.itheima.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.all_1.Customer;
import com.itheima.utils.HibernateUtil;

public class All_1_Test {
	
	/**
	 * 持久化对象的三种状态
	 */
	@Test
	public void test6_object_status2() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();

//		Customer c = session.get(Customer.class, 4);//持久态
		Customer c = session.load(Customer.class, 6);//持久态
		System.out.println(c.getClass());
		session.delete(c);
//		System.out.println(c.getName());
		
		tx.commit();
		session.close();
		System.out.println(c.getName());//托管态
	}
	
	
	/**
	 * 持久化对象的三种状态
	 */
	@Test
	public void test6_object_status() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer c = new Customer();//瞬时态
		c.setAddr("南京");
		c.setName("刘德华");
		
		session.save(c);//持久态 ，这个时候的c有OId
		
		tx.commit();
		session.close();
		System.out.println(c.getId());//托管态
	}
	
	
	
	/**
	 *get方式查询数据，如果数据库中没有数会返回null
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
		c.setName("黄盖");
		
		session.update(c);
		
		tx.commit();
		session.close();
	}
	
	@Test
	public void test1_save() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer c = new Customer();
		c.setAddr("南京");
		c.setName("周瑜");
		
		session.save(c);
		
		tx.commit();
		session.close();
	}
}

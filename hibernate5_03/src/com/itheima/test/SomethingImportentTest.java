package com.itheima.test;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.domain.Customer;
import com.itheima.utils.HibernateUtil;

/**
 * 优化策略
 * @author fanxh
 *
 */
public class SomethingImportentTest {

	/**
	 * 初始化延迟加载的对象
	 */
	@Test
	public void test1() {
		
		Session session = HibernateUtil.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Customer c = session.load(Customer.class, 1);
		
		//可以调用Hibernate的initialize方法对延迟加载的对象进行初始化
		Hibernate.initialize(c);
		
		tx.commit();	
	}
}

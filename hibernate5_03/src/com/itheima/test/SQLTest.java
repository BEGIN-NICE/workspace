package com.itheima.test;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.domain.Customer;
import com.itheima.utils.HibernateUtil;

public class SQLTest {
	
	/**
	 * 本地sql 命名检索
	 */
	@Test
	public void sqlTest2_mingMing() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		List list = session.getNamedQuery("findCustomer").list();
		
		System.out.println(list);
		
		tx.commit();
		session.close();
	}

	/**
	 * 本地sql基本检索
	 */
	@Test
	public void sqlTest() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//执行本地sql
		SQLQuery query = session.createSQLQuery("select * from t_customer");
		
		//将查询结果绑定对象
		query.addEntity(Customer.class);
		List<Customer> list = query.list();
		
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
}

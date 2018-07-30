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
	 * ����sql ��������
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
	 * ����sql��������
	 */
	@Test
	public void sqlTest() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//ִ�б���sql
		SQLQuery query = session.createSQLQuery("select * from t_customer");
		
		//����ѯ����󶨶���
		query.addEntity(Customer.class);
		List<Customer> list = query.list();
		
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
}

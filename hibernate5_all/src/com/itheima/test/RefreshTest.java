package com.itheima.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.all_6_criteria.Customer;
import com.itheima.all_6_criteria.Order;
import com.itheima.utils.HibernateUtil;

public class RefreshTest {
	
	/**
	 * refresh : ���²�ѯ���ݿ⣬�����ݿ�����Ϣ������һ�����������
	 */
	@Test
	public void test_prepare() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = session.get(Customer.class, 3);
		customer.setName("kkkk");
		System.out.println(customer.getName());
		session.refresh(customer);
		System.out.println(customer.getName());
		
		tx.commit();
		session.close();
	}
	@Test
	public void test_get() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		//customer �õ���null�����ᱨ��
		Customer customer = session.get(Customer.class, 30);
		System.out.println(customer);
		
		tx.commit();
		session.close();
	}
}

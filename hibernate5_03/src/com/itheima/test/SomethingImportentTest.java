package com.itheima.test;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.domain.Customer;
import com.itheima.utils.HibernateUtil;

/**
 * �Ż�����
 * @author fanxh
 *
 */
public class SomethingImportentTest {

	/**
	 * ��ʼ���ӳټ��صĶ���
	 */
	@Test
	public void test1() {
		
		Session session = HibernateUtil.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Customer c = session.load(Customer.class, 1);
		
		//���Ե���Hibernate��initialize�������ӳټ��صĶ�����г�ʼ��
		Hibernate.initialize(c);
		
		tx.commit();	
	}
}

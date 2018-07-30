package com.itheima.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.domain.Customer;
import com.itheima.utils.HibernateUtil;

public class SessionManageTest {

	/**
	 * ���Ի�ȡ��ͨ���̰߳󶨻�ȡ��session��ͬһ������
	 */
	@Test
	public void test1() {
		//ͨ��֮ǰ�ķ�����ȡ��session��ÿ�ζ���һ���µĶ���
		Session session1 = HibernateUtil.getSession();
		Session session2 = HibernateUtil.getSession();
		System.out.println(session1==session2);
		
		//ͨ����cfg.xml�ļ����� <property name="hibernate.current_session_context_class">thread</property>
		//Ȼ��ͨ��sessionFactory��getCurrentSession������þ��Ǹ���ǰ�̰߳󶨵�session
		//��session�������ύ����Զ��رգ������ֶ��رգ��ֶ��رջᱨ��
		Session session3 = HibernateUtil.getCurrentSession();
		Session session4 = HibernateUtil.getCurrentSession();
		System.out.println(session3==session4);
	}
	
	/**
	 *ʹ���̰߳󶨵�session����ע������
	 *��session�������ύ����Զ��رգ������ֶ��رգ��ֶ��رջᱨ��
	 *������Ϣ��org.hibernate.SessionException: Session was already closed
	 */
	@Test
	public void test2() {
		Session session = HibernateUtil.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Customer customer = session.get(Customer.class, 1);
		System.out.println(customer);
	
		tx.commit();
		//��session�������ύ����Զ��رգ������ֶ��رգ��ֶ��رջᱨ��
		//session.close();
		
	}
}

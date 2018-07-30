package com.itheima.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.junit.Test;

import com.itheima.domain.Customer;
import com.itheima.domain.Order;
import com.itheima.utils.HibernateUtil;

public class QBCTest {
	/**
	 * ���߼���
	 */
	@SuppressWarnings("all") 
	@Test
	public void qbcTest6() {
		//1.�õ�DetachedCriteria //�����ط�(����web��)��ɵĴ��룬ִ�н�dc��dao���ݼ���
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		dc.add(Restrictions.like("name","��_"));
		
		//����criteria����
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = dc.getExecutableCriteria(session);
		List<Customer> list = criteria.list();
		
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
	
	/**
	 * ͳ�Ʒ������
	 */
	@SuppressWarnings("all")
	@Test
	public void qbcTest5_groupBy() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//ͳ�ƶ�����
		Criteria criteria = session.createCriteria(Order.class);
		Object count = criteria.setProjection(Projections.rowCount()).uniqueResult();
		System.out.println(count);
		
		//���ݿͻ����з���ͳ�ƶ����ܽ��
		Criteria cri = session.createCriteria(Order.class);
//		cri.setProjection(Projections.sum("money")).setProjection(Projections.groupProperty("c"));
		cri.setProjection(Projections.projectionList().add(Projections.sum("money")).add(Projections.groupProperty("c")));
		List<Object[]> list = cri.list();
		for (Object[] objects : list) {
			for (Object object : objects) {
				System.out.println(object);
			}
		}
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
	
	/**
	 * ��ҳ����
	 */
	@SuppressWarnings("all")
	@Test
	public void qbcTest4_page() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Order.class);
		criteria.addOrder(org.hibernate.criterion.Order.asc("money"));
		criteria.setFirstResult((2-1)*7);
		criteria.setMaxResults(5);
		
		List<Order> list = criteria.list();
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
	
	/**
	 * ��������
	 */
	@Test
	public void qbcTest3() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//��ѯ����Ϊ��ĳ�Ŀͻ�������������
		Criteria criteria = session.createCriteria(Customer.class);
		SimpleExpression like = Restrictions.like("name", "��_");//��������  lt <,gt >,eq ==,le <=,ge >=
		criteria.add(like);
		//��֪����ѯ���ֻ��һ��ʱ������������
		Customer c = (Customer) criteria.uniqueResult();
		System.out.println(c);
		
		//��ѯ�����������۸���1050���ϣ���������Ϊ��ĳ
		Criteria cri = session.createCriteria(Order.class);
//		SimpleExpression gt = Restrictions.gt("money", 1050d);
//		SimpleExpression eq = Restrictions.eq("c", c);
//		LogicalExpression and = Restrictions.and(gt,eq);
//		List<Order> list = cri.add(and).list();
		//�������������������ʽ��̴���
		List<Order> list = cri.add(Restrictions.and(Restrictions.gt("money", 1050d),Restrictions.eq("c", c))).list();
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
	
	/**
	 * �������
	 */
	@Test
	public void qbcTest2_orderBy() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Order.class);
		//addOrder :����������������������ķ���
		//�����е�Order��hibernate�ṩ��
		//��������Ĳ����Ǹ����Ǹ����Խ�������
		criteria.addOrder(org.hibernate.criterion.Order.desc("money"));	
		List list = criteria.list();
		System.out.println(list);
		
		tx.commit();
		session.close();
	}

	/**
	 * ��������
	 */
	@Test
	public void qbcTest() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Customer.class);
		List list = criteria.list();
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
}

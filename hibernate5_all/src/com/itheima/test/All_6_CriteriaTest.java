package com.itheima.test;

import java.util.List;

import javax.security.auth.Subject;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.action.spi.Executable;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.itheima.all_6_criteria.Customer;
import com.itheima.all_6_criteria.Order;
import com.itheima.utils.HibernateUtil;

public class All_6_CriteriaTest {
	/**
	 * ���߼���
	 */
	@Test
	public void test_liXian() {
		DetachedCriteria dc = DetachedCriteria.forClass(Order.class);
		dc.add(Restrictions.gt("money", 2100d));
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = dc.getExecutableCriteria(session);
		List<Order> list = criteria.list();
		for (Order order : list) {
			System.out.println(order);
		}
		
		
		tx.commit();
		session.close();
	}
	
	/**
	 * ͳ�ƾۺϣ��������
	 */
	@Test
	public void test5_group() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Order.class);
		//ͳ�ƶ�������
//		Number count = (Number) criteria.setProjection(Projections.rowCount()).uniqueResult();
//		System.out.println(count.intValue());
		
		//ͳ�ƶ����ܽ��
//		Object result = criteria.setProjection(Projections.sum("money")).uniqueResult();
//		System.out.println(result);
		
		//���ݿͻ�����ͳ�ƶ����ܼ۸�
		List<Object[]> list = criteria.setProjection(Projections.projectionList().add(Projections.sum("money")).add(Projections.groupProperty("c"))).list();
		for (Object[] objects : list) {
			System.out.println(objects[0]+"=========="+objects[1]);
		}
		
		tx.commit();
		session.close();
	}
	
	@Test
	public void test4_page() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Order.class);
		List<Order> list = criteria.setFirstResult((3-1)*8).setMaxResults(8).list();
		for (Order order : list) {
			System.out.println(order);
		}
		
		tx.commit();
		session.close();
	}
	
	@Test
	public void test3_condition() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		//��ѯ�ͻ������� ���_ �����۸���2050���ϵĶ���
		Criteria criteria = session.createCriteria(Customer.class);
		Customer c = (Customer) criteria.add(Restrictions.like("name", "���_")).uniqueResult();
		
		Criteria criteria2 = session.createCriteria(Order.class);
		List<Order> list = criteria2.add(Restrictions.and(Restrictions.like("c", c),Restrictions.gt("money", 2050d))).list();
		for (Order order : list) {
			System.out.println(order);
		}
		System.out.println("========================");
		
		//��ѯ�ͻ������� ˾��_  ����  �����۸���2050���ϵĶ���
		Criteria criteria3 = session.createCriteria(Customer.class);
		Customer c2 = (Customer) criteria3.add(Restrictions.like("name", "˾��_")).uniqueResult();
		
		Criteria criteria4 = session.createCriteria(Order.class);
		List<Order> list2 = criteria4.add(Restrictions.or(Restrictions.like("c", c2),Restrictions.gt("money", 2050d))).list();
		for (Order order : list2) {
			System.out.println(order);
		}
		tx.commit();
		session.close();
	}
	
	@Test
	public void test2_order() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Order.class);
		List<Order> list = criteria.addOrder(org.hibernate.criterion.Order.desc("money")).list();
		for (Order order : list) {
			System.out.println(order);
		}
		
		tx.commit();
		session.close();
	}
	@Test
	public void test_get() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Customer.class);
		List<Customer> list = criteria.add(Restrictions.le("id", 5)).list();
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
	
	
	@Test
	public void test_prepare() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer c = new Customer();
		c.setName("�����");
		for (int i=0; i<20 ; i++) {
			Order order = new Order();
			order.setMoney(2000d+i*10);
			order.setReceiverInfo("����");
			order.setC(c);
			session.save(order);
		}
		
		tx.commit();
		session.close();
	}
}

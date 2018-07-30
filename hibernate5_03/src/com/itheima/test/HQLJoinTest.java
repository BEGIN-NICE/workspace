package com.itheima.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.domain.Customer;
import com.itheima.domain.Order;
import com.itheima.utils.HibernateUtil;

/**
 * hql ������
 * @author fanxh
 *
 */
public class HQLJoinTest {
	
	/*
	 * ����  ������������
	 * fetch���ܺ�withһ��ʹ�ã�Ҫ����Ӳ�ѯ����������ʹ��where��Ӳ�ѯ����
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void leftJoinTest5_fetch() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//ע�⣺���������ӵײ�Ҳ���������ӣ����Բ�ѯ��������ظ���Ҫʹ��distinctȥ��
		String hql = "select distinct c from Customer c left join fetch c.orders where c.id=3";
		List<Customer> list = session.createQuery(hql).list();//��ѯ�����from����Ķ���
		for (Customer c : list) {
			System.out.println(c);
		}
		System.out.println(list);
		tx.commit();
		session.close();
	}
	
	
	/*
	 * ����  ������
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void leftJoinTest4() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//ע�⣺���������ӵײ�Ҳ���������ӣ����Բ�ѯ��������ظ���Ҫʹ��distinctȥ��
		String hql = "from Customer c left join c.orders";
		List<Object[]> list = session.createQuery(hql).list();//��ѯ�����from����Ķ���
		for (Object[] objects : list) {
			for (Object object : objects) {
				System.out.print(object+"\t");
			}
			System.out.println();
		}
		System.out.println(list);
		tx.commit();
		session.close();
	}
	
	
	/*
	 * ����  ����������
	 * ���������ѯʱ��fetch ���ܸ�withһ��ʹ�ã�������where�������
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void innerJoinTest3() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		//����������    inner join fetch
		//String hql = "from Order o inner join fetch o.c";
		
		//ע�⣺���������ӵײ�Ҳ���������ӣ����Բ�ѯ��������ظ���Ҫʹ��distinctȥ��
		String hql = "select distinct c from Customer c inner join fetch c.orders where c.name like ?";
		List<Customer> list = session.createQuery(hql).setParameter(0, "��_").list();//��ѯ�����from����Ķ���
		for (Customer c : list) {
			System.out.println(c);
		}
		System.out.println(list);
		tx.commit();
		session.close();
	}
	
	/*
	 * ������ʽ������
	 */
	@Test
	public void innerJoinTest2() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		//����ʹ��with������Ӳ�ѯ����
		String hql = "from Order o where o.c.id = 1 and o.id <5";
		List<Order> list = session.createQuery(hql).list();
		
		System.out.println(list);
		tx.commit();
		session.close();
	}
	
	/*
	 * ������ʾ������
	 */
	@Test
	public void innerJoinTest1() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
//		String hql = "from Order o inner join o.c";
		//����ʹ��with������Ӳ�ѯ����  		//ò����whereҲ���ԣ�
		String hql = "from Order o inner join o.c with o.id = 1";
		List<Object[]> list = session.createQuery(hql).list();
		for (Object[] objects : list) {
			for (Object obj : objects) {
				System.out.print(obj +"\t");
			}
			System.out.println();
		}
		System.out.println(list);
		tx.commit();
		session.close();
	}
	
	
	//���û��������һ����¼�����ڲ���������
	@Test
	public void prepareTest() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = new Customer();
		customer.setName("����");
		session.save(customer);
		tx.commit();
		session.close();
	}
}

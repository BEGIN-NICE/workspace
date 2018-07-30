package com.itheima.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.domain.Customer;
import com.itheima.domain.Order;
import com.itheima.utils.HibernateUtil;

public class HQLTest {
	
	/**
	 * HQL ���������ѯ�Ĳ����Ƕ���
	 * 
	 */
	@Test
	public void hqlTest8() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		Customer c = session.get(Customer.class, 1);
		
		String hql = "from Order where c=:c";
		//List<Order> list = session.createQuery(hql).setEntity("c", c).list();
		//����Ҳ���Բ�ѯ��
		List<Order> list = session.createQuery(hql).setParameter("c", c).list();
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
	
	/**
	 * HQL ��������
	 * 
	 */
	@Test
	public void hqlTest7_mingMing() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		Object result = session.getNamedQuery("myHql").setParameter("id", 1).uniqueResult();
		System.out.println(result);
		
		
		tx.commit();
		session.close();
	}
	
	/**
	 * HQLͶӰ����
	 * ������Խ��в�ѯʱ�����Է�װ�������У�������ͶӰ
	 * 
	 */
	@Test
	public void hqlTest6_touYing() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		//��ѯ����customer��name
		String hql = "select name from Customer";
		List list = session.createQuery(hql).list();//�õ�����Object���� List<Object>
		System.out.println(list);
		
		//��ѯ����customer��name ��id
		String hql2 = "select id,name from Customer";
		List list2 = session.createQuery(hql2).list();//Object���͵����鼯�� List<Object[]>
		System.out.println(list2);
		
		//ʹ��ͶӰ����ѯ�����װ��Customer��   
		//Ҫ���������ɶ�Ӧ�����Ĺ��췽����ע�⣺�޲ι��첻Ҫ��д
		String hql3 = "select new Customer(id,name) from Customer";
		List<Customer> list3 = session.createQuery(hql3).list();//Object���͵����鼯�� List<Object[]>
		System.out.println(list3);
		
		tx.commit();
		session.close();
	}
	
	/**
	 * HQL�������
	 */
	@Test
	public void hqlTest5_groupBy() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		//��ѯ�������ܼ�¼��
		String hql = "select count(*) from Order";
		Object count = session.createQuery(hql).uniqueResult();
		System.out.println(count);
		
		//ͳ�ƶ�����Ǯ��������ͻ����з���
		String hql2 = "select sum(money) from Order group by c";
		List list = session.createQuery(hql2).list();
		
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
	
	/**
	 * HQL��ҳ����
	 */
	@Test
	public void hqlTest4_page() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		String hql = "from Order order by money desc";
		@SuppressWarnings("unchecked")
		List<Order> list = session.createQuery(hql)
				.setFirstResult(10)
				.setMaxResults(5)
				.list();
		
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
	
	/**
	 * HQL��������
	 */
	@Test
	public void hqlTest3() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		//�����Ʋ���
//		String hql = "from Order where o_money >?";
//		List<Order> list = session.createQuery(hql)
//				.setParameter(0, 1000d)
//				.list();
		//�����Ʋ���
		String hql = "from Order where money >:mymoney order by money desc";
		List<Order> list = session.createQuery(hql)
				.setParameter("mymoney", 1050d)
				.list();
		
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
	
	/**
	 * HQL�������
	 */
	@Test
	public void hqlTest2() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		String hql = "from Order order by money desc";
		List<Order> list = session.createQuery(hql).list();
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
	
	/**
	 * HQL��������
	 */
	@Test
	public void hqlTest() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		List<Customer> list = session.createQuery("from Customer").list();
		System.out.println(list.get(0));
		
		tx.commit();
		session.close();
	}
	
	/**
	 * HQL���ԵĲ���
	 * ׼����������
	 */
	@Test
	public void prepareTest() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Customer c = new Customer();
		c.setName("˾��ܲ");
		for(int i=0;i<10;i++) {
			Order order = new Order();
			order.setMoney(100d+i*10);
			order.setReceiverInfo("�Ϻ�");
			order.setC(c);
			session.save(order);
		}
		
		tx.commit();
		session.close();
	}
}

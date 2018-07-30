package com.itheima.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.itheima.all_1.Customer;
import com.itheima.utils.HibernateUtil;

public class SimpleHqlTest {
	
	//criteria
	@SuppressWarnings("unchecked")
	@Test
	public void test8_criteria_test() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Customer.class);
		
		//��ѯ����
		//List<Customer> list = criteria.list();
		
		//1����������ѯ
		List<Customer> list = criteria.add(Restrictions.and(Restrictions.or(Restrictions.eq("name", "���")
				,Restrictions.eq("addr", "�Ͼ�")))).list();
		System.out.println(list);
		
		//2����������ѯ  ����Ϊ���and��ַ���Ͼ�
//		criteria.add(Restrictions.eq("name", "���"));
//		criteria.add(Restrictions.eq("addr", "�Ͼ�"));
//		Customer customer = (Customer) criteria.uniqueResult();
//		System.out.println(customer);

		//��������ѯ  ����Ϊ��� or ��ַ���Ͼ�
//		List<Customer> list = criteria.add(Restrictions.or(Restrictions.eq("name", "���")
//				,Restrictions.eq("addr", "�Ͼ�"))).list();
//		for (Customer customer : list) {
//			System.out.println(customer);
//		}
		tx.commit();
		session.close();
	}
	
	
	//ִ�б���sql   ����������ѯ
	@Test
	public void test7_sql_test() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
			Customer customer = (Customer)session.createSQLQuery("select * from t_customer where name=?")
				.addEntity(Customer.class)
				.setParameter(0, "���")
				.uniqueResult();
		
			System.out.println(customer);

		
		tx.commit();
		session.close();
	}
	
	//ִ�б���sql
		@SuppressWarnings("unchecked")
		@Test
		public void test6_sql_test() {
			Session session = HibernateUtil.openSession();
			Transaction tx = session.beginTransaction();
			
			List<Customer> list = session.createSQLQuery("select * from t_customer")
					.addEntity(Customer.class)
					.list();
			for (Customer customer : list) {
				System.out.println(customer);
			}
			
			tx.commit();
			session.close();
		}
	
	//������ѯ
	@Test
	public void test5_condition() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		//�����������в�ѯ
		Customer c = (Customer) session.createQuery("from Customer where name=?")
		.setParameter(0, "���")
		.uniqueResult();//��֤���ֻ��һ������ʹ�����������ʹ��list
		System.out.println(c);
		
		tx.commit();
		session.close();
	}
	
	//ͶӰ��ѯ
	@Test
	public void test4_touYing() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
	
//		List<Object> list = session.createQuery("select name from Customer where id<:id")
//				.setParameter("id", 10)
//				.list();
//		System.out.println(list);
		
		
		@SuppressWarnings("unchecked")
		List<Customer> list = session.createQuery("select new Customer(name,addr) from Customer where id<:id")
				.setParameter("id", 10)
				.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		
			//	����ת������	
//		List<Customer> list = session.createQuery("select addr from Customer where id<:id")
//				.setParameter("id", 10)
//				.list();
//		for (Customer customer : list) {
//			System.out.println(customer);
//		}
		tx.commit();
		session.close();
	}
	
	//��ҳ��ѯ
	@SuppressWarnings("unchecked")
	@Test
	public void test3_page() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		List<Customer> list = session.createQuery("from Customer")
				.setFirstResult(10)//��ʼ��λ�ã�С���һ��ʼ
				.setMaxResults(10)//��ѯ������
				.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		 
		tx.commit();
		session.close();
	}
	
	
	//��ѯ����
	@SuppressWarnings("unchecked")
	@Test
	public void test2_list() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		List<Customer> list = session.createQuery("from Customer").list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		
		tx.commit();
		session.close();
	}
	
	@Test
	public void test1_compare() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		for(int i=0;i<50;i++) {
		Customer c = new Customer();
		c.setAddr("�Ͼ�");
		c.setName("���"+i);
		
		session.save(c);
		}
		
		tx.commit();
		session.close();
	}
}

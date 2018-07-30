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
		
		//查询所有
		//List<Customer> list = criteria.list();
		
		//1：多条件查询
		List<Customer> list = criteria.add(Restrictions.and(Restrictions.or(Restrictions.eq("name", "周瑜")
				,Restrictions.eq("addr", "南京")))).list();
		System.out.println(list);
		
		//2：多条件查询  姓名为周瑜and地址是南京
//		criteria.add(Restrictions.eq("name", "周瑜"));
//		criteria.add(Restrictions.eq("addr", "南京"));
//		Customer customer = (Customer) criteria.uniqueResult();
//		System.out.println(customer);

		//多条件查询  姓名为周瑜 or 地址是南京
//		List<Customer> list = criteria.add(Restrictions.or(Restrictions.eq("name", "周瑜")
//				,Restrictions.eq("addr", "南京"))).list();
//		for (Customer customer : list) {
//			System.out.println(customer);
//		}
		tx.commit();
		session.close();
	}
	
	
	//执行本地sql   根据条件查询
	@Test
	public void test7_sql_test() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
			Customer customer = (Customer)session.createSQLQuery("select * from t_customer where name=?")
				.addEntity(Customer.class)
				.setParameter(0, "周瑜")
				.uniqueResult();
		
			System.out.println(customer);

		
		tx.commit();
		session.close();
	}
	
	//执行本地sql
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
	
	//条件查询
	@Test
	public void test5_condition() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		//根据姓名进行查询
		Customer c = (Customer) session.createQuery("from Customer where name=?")
		.setParameter(0, "周瑜")
		.uniqueResult();//保证结果只有一条可以使用这个，多条使用list
		System.out.println(c);
		
		tx.commit();
		session.close();
	}
	
	//投影查询
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
		
			//	类型转换错误	
//		List<Customer> list = session.createQuery("select addr from Customer where id<:id")
//				.setParameter("id", 10)
//				.list();
//		for (Customer customer : list) {
//			System.out.println(customer);
//		}
		tx.commit();
		session.close();
	}
	
	//分页查询
	@SuppressWarnings("unchecked")
	@Test
	public void test3_page() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		List<Customer> list = session.createQuery("from Customer")
				.setFirstResult(10)//开始的位置，小标从一开始
				.setMaxResults(10)//查询的条数
				.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		 
		tx.commit();
		session.close();
	}
	
	
	//查询所有
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
		c.setAddr("南京");
		c.setName("周瑜"+i);
		
		session.save(c);
		}
		
		tx.commit();
		session.close();
	}
}

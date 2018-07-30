package com.itheima.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.domain.Customer;
import com.itheima.domain.Order;
import com.itheima.utils.HibernateUtil;

/**
 * hql 多表操作
 * @author fanxh
 *
 */
public class HQLJoinTest {
	
	/*
	 * 测试  迫切左外连接
	 * fetch不能和with一起使用，要想添加查询条件，可以使用where添加查询条件
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void leftJoinTest5_fetch() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//注意：迫切内连接底层也是用内连接，所以查询结果可能重复，要使用distinct去重
		String hql = "select distinct c from Customer c left join fetch c.orders where c.id=3";
		List<Customer> list = session.createQuery(hql).list();//查询结果是from后面的对象
		for (Customer c : list) {
			System.out.println(c);
		}
		System.out.println(list);
		tx.commit();
		session.close();
	}
	
	
	/*
	 * 测试  外连接
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void leftJoinTest4() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//注意：迫切内连接底层也是用内连接，所以查询结果可能重复，要使用distinct去重
		String hql = "from Customer c left join c.orders";
		List<Object[]> list = session.createQuery(hql).list();//查询结果是from后面的对象
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
	 * 测试  迫切内连接
	 * 添加条件查询时，fetch 不能跟with一起使用，可以用where添加条件
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void innerJoinTest3() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		//迫切内连接    inner join fetch
		//String hql = "from Order o inner join fetch o.c";
		
		//注意：迫切内连接底层也是用内连接，所以查询结果可能重复，要使用distinct去重
		String hql = "select distinct c from Customer c inner join fetch c.orders where c.name like ?";
		List<Customer> list = session.createQuery(hql).setParameter(0, "凤_").list();//查询结果是from后面的对象
		for (Customer c : list) {
			System.out.println(c);
		}
		System.out.println(list);
		tx.commit();
		session.close();
	}
	
	/*
	 * 测试隐式内连接
	 */
	@Test
	public void innerJoinTest2() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		//可以使用with添加连接查询条件
		String hql = "from Order o where o.c.id = 1 and o.id <5";
		List<Order> list = session.createQuery(hql).list();
		
		System.out.println(list);
		tx.commit();
		session.close();
	}
	
	/*
	 * 测试显示内连接
	 */
	@Test
	public void innerJoinTest1() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
//		String hql = "from Order o inner join o.c";
		//可以使用with添加连接查询条件  		//貌似用where也可以？
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
	
	
	//向用户表中添加一条记录，便于测试外链接
	@Test
	public void prepareTest() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = new Customer();
		customer.setName("关羽");
		session.save(customer);
		tx.commit();
		session.close();
	}
}

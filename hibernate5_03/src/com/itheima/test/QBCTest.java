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
	 * 离线检索
	 */
	@SuppressWarnings("all") 
	@Test
	public void qbcTest6() {
		//1.得到DetachedCriteria //其他地方(例如web层)完成的代码，执行将dc往dao传递即可
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		dc.add(Restrictions.like("name","凤_"));
		
		//生成criteria对象
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = dc.getExecutableCriteria(session);
		List<Customer> list = criteria.list();
		
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
	
	/**
	 * 统计分组检索
	 */
	@SuppressWarnings("all")
	@Test
	public void qbcTest5_groupBy() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//统计订单数
		Criteria criteria = session.createCriteria(Order.class);
		Object count = criteria.setProjection(Projections.rowCount()).uniqueResult();
		System.out.println(count);
		
		//根据客户进行分组统计订单总金额
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
	 * 分页检索
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
	 * 条件检索
	 */
	@Test
	public void qbcTest3() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//查询姓名为凤某的客户，姓名两个字
		Criteria criteria = session.createCriteria(Customer.class);
		SimpleExpression like = Restrictions.like("name", "凤_");//其他条件  lt <,gt >,eq ==,le <=,ge >=
		criteria.add(like);
		//当知道查询结果只有一个时，可以用下面
		Customer c = (Customer) criteria.uniqueResult();
		System.out.println(c);
		
		//查询订单，订单价格在1050以上，并且姓名为张某
		Criteria cri = session.createCriteria(Order.class);
//		SimpleExpression gt = Restrictions.gt("money", 1050d);
//		SimpleExpression eq = Restrictions.eq("c", c);
//		LogicalExpression and = Restrictions.and(gt,eq);
//		List<Order> list = cri.add(and).list();
		//上面代码可以用下面的链式编程代替
		List<Order> list = cri.add(Restrictions.and(Restrictions.gt("money", 1050d),Restrictions.eq("c", c))).list();
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
	
	/**
	 * 排序检索
	 */
	@Test
	public void qbcTest2_orderBy() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Order.class);
		//addOrder :是用来进行添加排序条件的方法
		//参数中的Order是hibernate提供的
		//方法里面的参数是根据那个属性进行排序
		criteria.addOrder(org.hibernate.criterion.Order.desc("money"));	
		List list = criteria.list();
		System.out.println(list);
		
		tx.commit();
		session.close();
	}

	/**
	 * 基本检索
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

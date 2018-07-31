package com.itheima.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.utils.HibernateUtil;

public class All_5_HqlTest {
	
	
	
	@Test
	public void test2_order_group() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		/*String hql = " select sum(money) from Order group by c order by sum(money) desc ";
		List<Object> list = session.createQuery(hql).list();
		for (Object object : list) {
			System.out.println(object);
		}*/
		String hql = " select c.name, sum(money) from Order group by c order by sum(money) desc ";
		List<Object[]> list = session.createQuery(hql).list();
		System.out.println(list);
		for (Object[] objects : list) {
			System.out.println(objects[0]+"------"+objects[1]);
		}
		
		tx.commit();
		session.close();
	}
	@Test
	public void test_inner_join() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
//		String hql = "from Customer c inner join c.orders where c.id=1";
		String hql = "from Customer c inner join c.orders with c.id=1";
		List<Object[]> list = session.createQuery(hql).list();
		for (Object[] obj : list) {
			System.out.println(obj[0]+"-----"+obj[1]);
		}
		
		tx.commit();
		session.close();
	}
	
}

package com.itheima.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.domain.Customer;
import com.itheima.utils.HibernateUtil;

public class SessionManageTest {

	/**
	 * 测试获取的通过线程绑定获取的session是同一个对象
	 */
	@Test
	public void test1() {
		//通过之前的方法获取的session，每次都是一个新的对象
		Session session1 = HibernateUtil.getSession();
		Session session2 = HibernateUtil.getSession();
		System.out.println(session1==session2);
		
		//通多在cfg.xml文件配置 <property name="hibernate.current_session_context_class">thread</property>
		//然后通过sessionFactory的getCurrentSession方法获得就是跟当前线程绑定的session
		//此session在事务提交后会自动关闭，无需手动关闭，手动关闭会报错
		Session session3 = HibernateUtil.getCurrentSession();
		Session session4 = HibernateUtil.getCurrentSession();
		System.out.println(session3==session4);
	}
	
	/**
	 *使用线程绑定的session对象注意事项
	 *此session在事务提交后会自动关闭，无需手动关闭，手动关闭会报错
	 *错误信息：org.hibernate.SessionException: Session was already closed
	 */
	@Test
	public void test2() {
		Session session = HibernateUtil.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Customer customer = session.get(Customer.class, 1);
		System.out.println(customer);
	
		tx.commit();
		//此session在事务提交后会自动关闭，无需手动关闭，手动关闭会报错
		//session.close();
		
	}
}

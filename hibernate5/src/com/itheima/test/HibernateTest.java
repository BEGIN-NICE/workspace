package com.itheima.test;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.itheima.domain.User;
import com.itheima.utils.HibernateUtil;

public class HibernateTest {
	@Test
	public void saveTest() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		User user = new User();
		user.setName("夏明");
		user.setBirth(new Date());
		session.save(user);
		
		transaction.commit();
		session.close();
	}
	
	@Test
	public void getTest() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		User user = session.get(User.class, 1);
		System.out.println(user);
		
		transaction.commit();
		session.close();
	}
	
	@Test
	public void queryTest() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		List<User> list = session.createQuery("from User").list();
		System.out.println(list);
		
		transaction.commit();
		session.close();
	}
	
	/**
	 * 构造测试数据
	 */
	@Test
	public void saveAllTest() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		for (int i=3 ;i<101;i++) {
			User user = new User();
			user.setName("姓名"+i);
			user.setBirth(new Date());
			session.save(user);
		}
		
		transaction.commit();
		session.close();
	}
	
	
	/**
	 * hql,分页查询
	 */
	@Test
	public void HqlTest() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from User");
		query.setFirstResult(10);
		query.setMaxResults(20);
		List<User> list = query.list();
		System.out.println(list);
		
		transaction.commit();
		session.close();
	}
	
	/**
	 * hql,指定列查询
	 */
	@Test
	public void HqlTest2() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
//		查询单列
//		Query query = session.createQuery("select name from User");
//		List list = query.setMaxResults(10).list();
		
//		查询多列
//		Query query = session.createQuery("select id,name from User");
//		List<Object[]> list = query.setMaxResults(5).list();
		
//		查询多列,如果我们想要得到List<User>,可以使用hibernate中投影查询，我们只需要在User类中提供name和id作为参数的构造方法
		Query query = session.createQuery("select new User(id,name) from User");
		List<User> list = query.setMaxResults(5).list();
		
		System.out.println(list);
		
		transaction.commit();
		session.close();
	}
	
	/**
	 * hql,条件查询
	 */
	@Test
	public void HqlTest3() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		//无名称参数
//		Query query = session.createQuery("from User where name=?");
//		query.setParameter(0, "tom");
//		List<User> list = query.list();
		
		//有名称的参数
		Query query = session.createQuery("from User where name=:name");
		query.setParameter("name", "tom");
		
		
		//如果查询的结果只有一条
		User user = (User) query.uniqueResult();
		System.out.println(user);
		
		transaction.commit();
		session.close();
	}
	
	/**
	 * 本地sql,查询所有
	 */
	@Test
	public void sqlTest4() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		SQLQuery query = session.createSQLQuery("select * from user");
//		List<Object[]> list = query.list();
//		System.out.println(list);
		
		//将数据封装到User对象中
		query.addEntity(User.class);
		List<User> list = query.list();
		
		System.out.println(list);
		transaction.commit();
		session.close();
	}
	
	/**
	 * 本地sql,条件查询
	 */
	@Test
	public void sqlTest5() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		SQLQuery query = session.createSQLQuery("select * from user where name=?");
		query.setParameter(0, "tom");
		query.addEntity(User.class);
//		List<User> list = query.list();
//		System.out.println(list);
		//查询记录只有一条
		User user = (User) query.uniqueResult();
		System.out.println(user);
		transaction.commit();
		session.close();
	}
	
	/**
	 * Criteria测试
	 */
	@Test
	public void criteriaTest6() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		//得到Criteria对象
		Criteria criteria = session.createCriteria(User.class);
		
		//查询所有
//		List<User> list = criteria.list();
		
		//分页查询
//		criteria.setFirstResult(10);
//		criteria.setMaxResults(5);
//		List<User> list = criteria.list();
		
		//多条件查询
		//查询name=“tom”
		//criteria.add(Restrictions.eq("name", "tom"));
		//List list = criteria.list();
		//只有一条记录的
		//User user = (User) criteria.uniqueResult();
		
		//查询id=1 and name="tom"
		//criteria.add(Restrictions.eq("id", 1));
		//criteria.add(Restrictions.eq("name", "tom"));
		//List list = criteria.list();
		
		//查询id=2 or name="tom"
		criteria.add(Restrictions.or(Restrictions.eq("id",2 ),Restrictions.eq("name", "tom")));
		List list = criteria.list();
		
		System.out.println(list);
		transaction.commit();
		session.close();
	}
}

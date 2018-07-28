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
		user.setName("����");
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
	 * �����������
	 */
	@Test
	public void saveAllTest() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		for (int i=3 ;i<101;i++) {
			User user = new User();
			user.setName("����"+i);
			user.setBirth(new Date());
			session.save(user);
		}
		
		transaction.commit();
		session.close();
	}
	
	
	/**
	 * hql,��ҳ��ѯ
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
	 * hql,ָ���в�ѯ
	 */
	@Test
	public void HqlTest2() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
//		��ѯ����
//		Query query = session.createQuery("select name from User");
//		List list = query.setMaxResults(10).list();
		
//		��ѯ����
//		Query query = session.createQuery("select id,name from User");
//		List<Object[]> list = query.setMaxResults(5).list();
		
//		��ѯ����,���������Ҫ�õ�List<User>,����ʹ��hibernate��ͶӰ��ѯ������ֻ��Ҫ��User�����ṩname��id��Ϊ�����Ĺ��췽��
		Query query = session.createQuery("select new User(id,name) from User");
		List<User> list = query.setMaxResults(5).list();
		
		System.out.println(list);
		
		transaction.commit();
		session.close();
	}
	
	/**
	 * hql,������ѯ
	 */
	@Test
	public void HqlTest3() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		//�����Ʋ���
//		Query query = session.createQuery("from User where name=?");
//		query.setParameter(0, "tom");
//		List<User> list = query.list();
		
		//�����ƵĲ���
		Query query = session.createQuery("from User where name=:name");
		query.setParameter("name", "tom");
		
		
		//�����ѯ�Ľ��ֻ��һ��
		User user = (User) query.uniqueResult();
		System.out.println(user);
		
		transaction.commit();
		session.close();
	}
	
	/**
	 * ����sql,��ѯ����
	 */
	@Test
	public void sqlTest4() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		SQLQuery query = session.createSQLQuery("select * from user");
//		List<Object[]> list = query.list();
//		System.out.println(list);
		
		//�����ݷ�װ��User������
		query.addEntity(User.class);
		List<User> list = query.list();
		
		System.out.println(list);
		transaction.commit();
		session.close();
	}
	
	/**
	 * ����sql,������ѯ
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
		//��ѯ��¼ֻ��һ��
		User user = (User) query.uniqueResult();
		System.out.println(user);
		transaction.commit();
		session.close();
	}
	
	/**
	 * Criteria����
	 */
	@Test
	public void criteriaTest6() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		//�õ�Criteria����
		Criteria criteria = session.createCriteria(User.class);
		
		//��ѯ����
//		List<User> list = criteria.list();
		
		//��ҳ��ѯ
//		criteria.setFirstResult(10);
//		criteria.setMaxResults(5);
//		List<User> list = criteria.list();
		
		//��������ѯ
		//��ѯname=��tom��
		//criteria.add(Restrictions.eq("name", "tom"));
		//List list = criteria.list();
		//ֻ��һ����¼��
		//User user = (User) criteria.uniqueResult();
		
		//��ѯid=1 and name="tom"
		//criteria.add(Restrictions.eq("id", 1));
		//criteria.add(Restrictions.eq("name", "tom"));
		//List list = criteria.list();
		
		//��ѯid=2 or name="tom"
		criteria.add(Restrictions.or(Restrictions.eq("id",2 ),Restrictions.eq("name", "tom")));
		List list = criteria.list();
		
		System.out.println(list);
		transaction.commit();
		session.close();
	}
}

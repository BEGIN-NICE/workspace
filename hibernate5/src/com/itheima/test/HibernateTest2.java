package com.itheima.test;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.domain.User;
import com.itheima.utils.HibernateUtil;

public class HibernateTest2 {

	/**
	 * 测试持久化对象三种状态
	 */
	@Test
	public void statusTest() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		User user = new User();//瞬时态(无oid,与session无关联)
		user.setName("关羽");
		user.setBirth(new Date());
		
		session.save(user);//建立了user与session的关联关系，它就是持久态(有oid)
		
		tx.commit();
		session.close();
		System.out.println(user);//断开了与session的联系，它是托管态(有oid)
	}
	
	/**
	 * 测试一级缓存
	 */
	@Test
	public void Test1() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		User user = session.get(User.class, 1);//向数据库发送sql语句
		User user2 = session.get(User.class, 1);//不会发送sql数据
		
		tx.commit();
		session.close();
	}
	/**
	 * 测试持久化对象具有更新数据库的能力
	 */
	@Test
	public void Test2() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		User user = session.get(User.class, 5);
		user.setName("刘备");//操作持久化对象来修改属性
		
		tx.commit();//更新到数据库
		session.close();
	}
	
	/**
	 * 测试一级缓存常用的API
	 */
	@Test
	public void Test3() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from User");
		List list = query.list();//存储数据到一级缓存
		
		session.clear();//清空一级缓存
		User user = session.get(User.class, 1);
		
		session.evict(user);//从一级缓存中清除指定的对象
		User user2 = session.get(User.class, 1);
		
		user2.setName("曹操");
		session.refresh(user2);//从新查询数据库信息，用数据库信息来更新我们的一级缓存和快照 
		
		tx.commit();
		session.close();
	}
}

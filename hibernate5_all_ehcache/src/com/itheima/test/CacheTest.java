package com.itheima.test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.FlushModeType;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.itheima.domain.Book;
import com.itheima.domain.Catregory;
import com.itheima.utils.HibernateUtil;

public class CacheTest {
	
	/**
	 * 一级缓存的管理------flush
	 */
	@Test
	public void test4_sessionManager() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		Catregory c = new Catregory();
		c.setName("悬疑");
		session.flush();
		
		session.save(c);
		
		tx.commit();
		session.close();
	}
	
	/**
	 * 不去查看缓存也还是不会查看缓存，和缓存级别无关
	 */
	@Test
	public void test3_ehcache_get_list() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from Book";
		Catregory c = session.get(Catregory.class, 1);
		System.out.println(c);
		session.clear();
		System.out.println("---------------");
		Catregory c2 = session.get(Catregory.class, 1);
		System.out.println(c2);
		System.out.println("====================================");
		
		List list = session.createCriteria(Catregory.class).list();
		System.out.println(list.size());
		System.out.println("-----------------");
		List list2 = session.createCriteria(Catregory.class).list();
		System.out.println(list2.size());
		
		tx.commit();
		session.close();
	}
	
	/**
	 * iterate：每次都会发出查询id的sql语句，当查询每条记录时，会先查询session缓存，并且会将查询记录保存到session缓存中
	 */
	@Test
	public void test2_session_iterate() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from Book";
		Iterator<Book> iterate = session.createQuery(hql).iterate();
		while (iterate.hasNext()) {
			Book book = (Book) iterate.next();
			System.out.println(book);
		}
		System.out.println("=========================");
		Book book2 = session.get(Book.class, 1);
		System.out.println(book2);
		
		System.out.println("=========================");
		Iterator<Book> iterate2 = session.createQuery(hql).iterate();
		while (iterate2.hasNext()) {
			Book book = (Book) iterate2.next();
			System.out.println(book);
		}
		tx.commit();
		session.close();
	}
	

	
	/**
	 * list,unique 会将查询结果放入session，但是下次查询不会先查看session缓存
	 */
	@Test
	public void test2_session_list_unique() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		List<Catregory> list = session.createCriteria(Catregory.class).list();
		System.out.println(list.size());
		
		Catregory catregory = session.get(Catregory.class, 1);
		System.out.println(catregory);
		
		List<Catregory> list2 = session.createCriteria(Catregory.class).list();
		System.out.println(list2.size());
		
		System.out.println("====================================");
		Object result = session.createCriteria(Catregory.class).add(Restrictions.eq("id", 3)).uniqueResult();
		System.out.println(result);
		
		Catregory catregory2 = session.get(Catregory.class, 3);
		System.out.println(catregory2);
		
		Object result2 = session.createCriteria(Catregory.class).add(Restrictions.eq("id", 3)).uniqueResult();
		System.out.println(result2);
		
		tx.commit();
		session.close();
	}
	
	
	@Test
	public void test_prepare() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		Catregory c = new Catregory();
		c.setName("文学");
		Catregory c1 = new Catregory();
		c1.setName("仙侠");
		Catregory c2 = new Catregory();
		c2.setName("科幻");
		Catregory c3 = new Catregory();
		c3.setName("历史");
		Catregory c4 = new Catregory();
		c4.setName("恐怖");
		
		Book book = new Book();
		book.setAuthor("莫言");
		book.setPrice(88);
		book.setName("丰乳肥臀");
		book.setPubDate(new Date());
		
		Book book1 = new Book();
		book1.setAuthor("简*爱");
		book1.setPrice(88);
		book1.setName("傲慢与偏见 ");
		book1.setPubDate(new Date());
		
		Book book2 = new Book();
		book2.setAuthor("高尔基 ");
		book2.setPrice(88);
		book2.setName("我的大学");
		book2.setPubDate(new Date());
		
		Book book3 = new Book();
		book3.setAuthor("莫言");
		book3.setPrice(88);
		book3.setName("缥缈峰之旅");
		book3.setPubDate(new Date());
		
		Book book4 = new Book();
		book4.setAuthor("卫诗理");
		book4.setPrice(88);
		book4.setName("蓝雪人");
		book4.setPubDate(new Date());
		
		Book book5 = new Book();
		book5.setAuthor("人民");
		book5.setPrice(88);
		book5.setName("历史");
		book5.setPubDate(new Date());
		
		
		c.getBooks().add(book);
		c.getBooks().add(book1);
		c.getBooks().add(book2);
		c1.getBooks().add(book3);
		c2.getBooks().add(book4);
		c3.getBooks().add(book5);
		
		session.save(c);
		session.save(c1);
		session.save(c2);
		session.save(c3);
		session.save(c4);

		tx.commit();
		session.close();
	}
}

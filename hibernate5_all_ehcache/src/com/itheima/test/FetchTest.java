package com.itheima.test;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.experimental.categories.Categories;

import com.itheima.domain.Book;
import com.itheima.domain.Catregory;
import com.itheima.utils.HibernateUtil;

public class FetchTest {
	/**
	 * N+1问题
	 */
	
	//一的一端导航查询多的一端
	@Test
	public void test4_N_1() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		List<Catregory> list = session.createCriteria(Catregory.class).list();
		for (Catregory catregory : list) {
			System.out.println(catregory.getBooks().size());
		}
		
		
		tx.commit();
		session.close();
	}
	
	
	/**
	 *多的一端查询一的一端
	 */
	@Test
	public void test3_N_1() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		List<Book> list = session.createCriteria(Book.class).list();
		for (Book book : list) {
			System.out.println(book.getCatregory().getName());
		}
		
		
		tx.commit();
		session.close();
	}
	
	
	
	/**
	 * 多对一的一端测试
	 */
	@Test
	public void test2_manyToOne() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		Book book = session.get(Book.class, 1);
		
		System.out.println(book);
		System.out.println("===================");
		System.out.println(book.getCatregory());
		
		
		tx.commit();
		session.close();
	}
	
	
	/**
	 * 一对多的一端设置
	 */
	
	@Test
	public void test_set() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		Catregory c = session.get(Catregory.class, 1);
		
		System.out.println(c);
		System.out.println("===================");
		System.out.println(c.getBooks().size());
		
		
		tx.commit();
		session.close();
	}
}

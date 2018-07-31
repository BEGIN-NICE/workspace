package com.itheima.test;

import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.my_list_map.Book;
import com.itheima.my_list_map.Category;
import com.itheima.utils.HibernateUtil;

public class my_Map_ListTest {
	
	@Test
	public void test2_get() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		Category c = session.get(Category.class, 1);
		Map<String, Book> map = c.getBookMap();
		Set<Entry<String,Book>> set = map.entrySet();
		for (Entry<String, Book> entry : set) {
			System.out.println(entry.getKey()+"========"+entry.getValue().getPubDate());
		}
	
		
		tx.commit();
		session.close();
	}
	

	@Test
	public void test_list_map() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();

		Category c = new Category();
		c.setAuthor("ÄªÑÔ");
		c.setName("ÎÄÑ§");
		Category c2 = new Category();
		c2.setAuthor("Ðþ»Ã");
		c2.setName("Ìì²ÏÍÁ¶¹");
		
		Book b = new Book();
		b.setName("·áÈé·ÊÍÎ");
		b.setPubDate(new Date());
		
		Book b2 = new Book();
		b2.setName("ÍÜ");
		b2.setPubDate(new Date());
	
		Book b3 = new Book();
		b3.setName("ºì¸ßÁ»");
		b3.setPubDate(new Date());
	
		Book b4 = new Book();
		b4.setName("çÎç¿Ö®ÂÃ");
		b4.setPubDate(new Date());
		
		Book b5 = new Book();
		b5.setName("¶·ÆÆ²Ôñ·");
		b5.setPubDate(new Date());
		
		
		b.setCategory(c);
		b2.setCategory(c);
		b3.setCategory(c);
		b4.setCategory(c2);
		b5.setCategory(c2);
		
		//list¼¯ºÏ
//		c.getBooks().add(b);
//		c.getBooks().add(b2);
//		c.getBooks().add(b3);
//		c2.getBooks().add(b4);
//		c2.getBooks().add(b5);

		c.getBookMap().put(b.getName(), b);
		c.getBookMap().put(b2.getName(), b2);
		c.getBookMap().put(b3.getName(), b3);
		c2.getBookMap().put(b4.getName(), b4);
		c2.getBookMap().put(b5.getName(), b5);
		
		session.save(b);
		session.save(b2);
		session.save(b3);
		session.save(b4);
		session.save(b5);
		
		tx.commit();
		session.close();
	}
	
	
}

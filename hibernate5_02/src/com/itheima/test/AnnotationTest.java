package com.itheima.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.annotation.Book;
import com.itheima.annotation.Person;
import com.itheima.annotation.manytomany.Student;
import com.itheima.annotation.manytomany.Teacher;
import com.itheima.annotation.onetoone.Husband;
import com.itheima.annotation.onetoone.IDCard;
import com.itheima.annotation.onetoone.User;
import com.itheima.annotation.onetoone.Wife;
import com.itheima.utils.HibernateUtil;

public class AnnotationTest {
	
	/**
	 * 一对一主键映射注解开发的测试
	 * 一对一保存数据测试
	 */
	@Test
	public void oneToOneTest2() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
	
		Husband husband = new Husband();
		husband.setName("周瑜");
		
		Wife wife = new Wife();
		wife.setName("小乔");
		wife.setHusband(husband);
		husband.setWife(wife);
		session.save(wife);
		
		tx.commit();
		session.close();
	}
	
	
	/**
	 * 一对一外键映射注解开发的测试
	 * 一对一保存数据测试
	 */
	@Test
	public void oneToOneTest() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
	
		User user = new User();
		user.setName("赵子龙");
		
		IDCard card = new IDCard();
		card.setCardNum("123456789");
		card.setUser(user);
		//user.setIdCard(card);
		
		session.save(card);
		
		tx.commit();
		session.close();
	}
	
	
	/**
	 * 多对多注解开发的测试
	 * 查询测试
	 */
	@Test
	public void manytomanyTest3() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Student stu = session.load(Student.class, 1);
		System.out.println(stu.getName()+"   "+stu.getTeachers());
		
		tx.commit();
		session.close();
	}
	/**
	 * 多对多注解开发的测试
	 * 多对多级联删除数据(前提是建立了双向级联all)
	 */
	@Test
	public void manytomanyTest2() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
	
		Student stu = session.get(Student.class, 1);
		session.delete(stu);
		
		tx.commit();
		session.close();
	}
	/**
	 * 多对多注解开发的测试
	 * 多对多级联保存数据(保存学生时保存老师)
	 */
	@Test
	public void manytomanyTest() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Teacher t = new Teacher();
		t.setName("于善波");
		Teacher t2 = new Teacher();
		t2.setName("沈叶旺");
		
		Student s = new Student();
		s.setName("冯杰");
		Student s2 = new Student();
		s2.setName("严超云");
		
		t.getStudents().add(s);
		t2.getStudents().add(s2);
		
		s.getTeachers().add(t);
		s.getTeachers().add(t2);
		s2.getTeachers().add(t);
		s2.getTeachers().add(t2);
		
		session.save(s);
		session.save(s2);
		
		tx.commit();
		session.close();
	}
	
	
	/**
	 * 采用注解设置主键生成策略为UUID，并且完成po类中某个属性不在表中生成
	 * UUID生成策略没有，可以自定义，然后引入
	 */
	@Test
	public void person_Test() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Person person = new Person();
		person.setName("诸葛亮");
		person.setMsg("不在表中生成");
		session.save(person);
		
		tx.commit();
		session.close();
	}
	
	/**
	 * 注解开发测试
	 */
	@Test
	public void book_Test() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Book book = new Book();
		book.setName("三国演义");
		book.setPrice(99.9);
		book.setPublicationDate(new Date());
		session.save(book);
		
		tx.commit();
		session.close();
	}
}

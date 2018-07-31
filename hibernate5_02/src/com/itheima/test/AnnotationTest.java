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
	 * һ��һ����ӳ��ע�⿪���Ĳ���
	 * һ��һ�������ݲ���
	 */
	@Test
	public void oneToOneTest2() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
	
		Husband husband = new Husband();
		husband.setName("���");
		
		Wife wife = new Wife();
		wife.setName("С��");
		wife.setHusband(husband);
		husband.setWife(wife);
		session.save(wife);
		
		tx.commit();
		session.close();
	}
	
	
	/**
	 * һ��һ���ӳ��ע�⿪���Ĳ���
	 * һ��һ�������ݲ���
	 */
	@Test
	public void oneToOneTest() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
	
		User user = new User();
		user.setName("������");
		
		IDCard card = new IDCard();
		card.setCardNum("123456789");
		card.setUser(user);
		//user.setIdCard(card);
		
		session.save(card);
		
		tx.commit();
		session.close();
	}
	
	
	/**
	 * ��Զ�ע�⿪���Ĳ���
	 * ��ѯ����
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
	 * ��Զ�ע�⿪���Ĳ���
	 * ��Զ༶��ɾ������(ǰ���ǽ�����˫����all)
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
	 * ��Զ�ע�⿪���Ĳ���
	 * ��Զ༶����������(����ѧ��ʱ������ʦ)
	 */
	@Test
	public void manytomanyTest() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Teacher t = new Teacher();
		t.setName("���Ʋ�");
		Teacher t2 = new Teacher();
		t2.setName("��Ҷ��");
		
		Student s = new Student();
		s.setName("���");
		Student s2 = new Student();
		s2.setName("�ϳ���");
		
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
	 * ����ע�������������ɲ���ΪUUID���������po����ĳ�����Բ��ڱ�������
	 * UUID���ɲ���û�У������Զ��壬Ȼ������
	 */
	@Test
	public void person_Test() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Person person = new Person();
		person.setName("�����");
		person.setMsg("���ڱ�������");
		session.save(person);
		
		tx.commit();
		session.close();
	}
	
	/**
	 * ע�⿪������
	 */
	@Test
	public void book_Test() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Book book = new Book();
		book.setName("��������");
		book.setPrice(99.9);
		book.setPublicationDate(new Date());
		session.save(book);
		
		tx.commit();
		session.close();
	}
}

package com.itheima.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.my_extends.Student;
import com.itheima.my_extends.Teacher;
import com.itheima.utils.HibernateUtil;

public class my_extendsTest {
	@Test
	public void test_condition() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Student student = new Student();
		student.setName("¹ØÓğ");
		student.setAge(28);
		student.setSex("ÄĞ");
		student.setWork("hibernate");
		
		Teacher t = new Teacher();
		t.setAge(35);
		t.setName("ÓÚÉÆ²¨");
		t.setSex("ÄĞ");
		t.setSalary(29999d);
		
		session.save(student);
		session.save(t);
		
		tx.commit();
		session.close();
	}
	
}

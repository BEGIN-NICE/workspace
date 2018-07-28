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
	 * ���Գ־û���������״̬
	 */
	@Test
	public void statusTest() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		User user = new User();//˲ʱ̬(��oid,��session�޹���)
		user.setName("����");
		user.setBirth(new Date());
		
		session.save(user);//������user��session�Ĺ�����ϵ�������ǳ־�̬(��oid)
		
		tx.commit();
		session.close();
		System.out.println(user);//�Ͽ�����session����ϵ�������й�̬(��oid)
	}
	
	/**
	 * ����һ������
	 */
	@Test
	public void Test1() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		User user = session.get(User.class, 1);//�����ݿⷢ��sql���
		User user2 = session.get(User.class, 1);//���ᷢ��sql����
		
		tx.commit();
		session.close();
	}
	/**
	 * ���Գ־û�������и������ݿ������
	 */
	@Test
	public void Test2() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		User user = session.get(User.class, 5);
		user.setName("����");//�����־û��������޸�����
		
		tx.commit();//���µ����ݿ�
		session.close();
	}
	
	/**
	 * ����һ�����泣�õ�API
	 */
	@Test
	public void Test3() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from User");
		List list = query.list();//�洢���ݵ�һ������
		
		session.clear();//���һ������
		User user = session.get(User.class, 1);
		
		session.evict(user);//��һ�����������ָ���Ķ���
		User user2 = session.get(User.class, 1);
		
		user2.setName("�ܲ�");
		session.refresh(user2);//���²�ѯ���ݿ���Ϣ�������ݿ���Ϣ���������ǵ�һ������Ϳ��� 
		
		tx.commit();
		session.close();
	}
}

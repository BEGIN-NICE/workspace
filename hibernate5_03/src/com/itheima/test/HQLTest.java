package com.itheima.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.domain.Customer;
import com.itheima.domain.Order;
import com.itheima.utils.HibernateUtil;

public class HQLTest {
	
	/**
	 * HQL 如果条件查询的参数是对象
	 * 
	 */
	@Test
	public void hqlTest8() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		Customer c = session.get(Customer.class, 1);
		
		String hql = "from Order where c=:c";
		//List<Order> list = session.createQuery(hql).setEntity("c", c).list();
		//下面也可以查询到
		List<Order> list = session.createQuery(hql).setParameter("c", c).list();
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
	
	/**
	 * HQL 命名检索
	 * 
	 */
	@Test
	public void hqlTest7_mingMing() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		Object result = session.getNamedQuery("myHql").setParameter("id", 1).uniqueResult();
		System.out.println(result);
		
		
		tx.commit();
		session.close();
	}
	
	/**
	 * HQL投影检索
	 * 多个属性进行查询时，可以分装到对象中，可以用投影
	 * 
	 */
	@Test
	public void hqlTest6_touYing() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		//查询所有customer的name
		String hql = "select name from Customer";
		List list = session.createQuery(hql).list();//得到的是Object集合 List<Object>
		System.out.println(list);
		
		//查询所有customer的name 和id
		String hql2 = "select id,name from Customer";
		List list2 = session.createQuery(hql2).list();//Object类型的数组集合 List<Object[]>
		System.out.println(list2);
		
		//使用投影将查询结果封装到Customer中   
		//要在类中生成对应参数的构造方法，注意：无参构造不要忘写
		String hql3 = "select new Customer(id,name) from Customer";
		List<Customer> list3 = session.createQuery(hql3).list();//Object类型的数组集合 List<Object[]>
		System.out.println(list3);
		
		tx.commit();
		session.close();
	}
	
	/**
	 * HQL分组检索
	 */
	@Test
	public void hqlTest5_groupBy() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		//查询订单的总记录数
		String hql = "select count(*) from Order";
		Object count = session.createQuery(hql).uniqueResult();
		System.out.println(count);
		
		//统计订单总钱数，按造客户进行分组
		String hql2 = "select sum(money) from Order group by c";
		List list = session.createQuery(hql2).list();
		
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
	
	/**
	 * HQL分页检索
	 */
	@Test
	public void hqlTest4_page() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		String hql = "from Order order by money desc";
		@SuppressWarnings("unchecked")
		List<Order> list = session.createQuery(hql)
				.setFirstResult(10)
				.setMaxResults(5)
				.list();
		
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
	
	/**
	 * HQL条件检索
	 */
	@Test
	public void hqlTest3() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		//无名称参数
//		String hql = "from Order where o_money >?";
//		List<Order> list = session.createQuery(hql)
//				.setParameter(0, 1000d)
//				.list();
		//有名称参数
		String hql = "from Order where money >:mymoney order by money desc";
		List<Order> list = session.createQuery(hql)
				.setParameter("mymoney", 1050d)
				.list();
		
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
	
	/**
	 * HQL排序检索
	 */
	@Test
	public void hqlTest2() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		String hql = "from Order order by money desc";
		List<Order> list = session.createQuery(hql).list();
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
	
	/**
	 * HQL基本检索
	 */
	@Test
	public void hqlTest() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		List<Customer> list = session.createQuery("from Customer").list();
		System.out.println(list.get(0));
		
		tx.commit();
		session.close();
	}
	
	/**
	 * HQL语言的测试
	 * 准备测试数据
	 */
	@Test
	public void prepareTest() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Customer c = new Customer();
		c.setName("司马懿");
		for(int i=0;i<10;i++) {
			Order order = new Order();
			order.setMoney(100d+i*10);
			order.setReceiverInfo("上海");
			order.setC(c);
			session.save(order);
		}
		
		tx.commit();
		session.close();
	}
}

package com.itheima.domain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.itheima.jdbc.utils.DruidUtil;
import com.itheima.jdbc.utils.c3p0Util;
import com.itheima.pojo.Account;


public class DBUtilTest {
	
	/**
	 * Object类型的数组可以在同一个数组中存储不同类型的数据：如下
	 * Object[]
	 */
	@Test
	public void test() {
		Object[] objs = new Object[3];
		objs[0] = "abc";
		objs[1] = 12;
		System.err.println(Arrays.toString(objs));
		
		DataSource d1 = DruidUtil.getDataSource();
		DataSource d2 = DruidUtil.getDataSource();
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d1==d2);
		
		DataSource dc31 = c3p0Util.getDataSource();
		DataSource dc32 = c3p0Util.getDataSource();
		System.out.println(dc31);
		System.out.println(dc32);
		System.out.println(dc31==dc32);
		
		Properties pro1 = DruidUtil.getPro();
		Properties pro2 = DruidUtil.getPro();
		System.out.println(pro1==pro2);
		
	}
	/**
	 * 添加操作
	 */
	@Test
	public void insertTest() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		queryRunner.update("insert into user1 values (null,?)","fanxh");
	}
	
	/**
	 * 修改操作
	 * @throws SQLException 
	 */
	@Test
	public void updateTest() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		int update = queryRunner.update("update account set name = ?,money = ? where id = ?", "杨过",99999,1);
		if(update > 0) {
			System.out.println("修改成功");
		}
	}
	
	/**
	 * 修改操作
	 * @throws SQLException 
	 */
	@Test
	public void deleteTest() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		int update = queryRunner.update("delete from user1 where name = ?", "fanxh");
		if (update > 0) {
			System.out.println("删除成功");
		}
		
	}
	

	/**
	 * 修改操作
	 * @throws SQLException 
	 */
	@Test
	public void batchTest() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		int[] batch = queryRunner.batch("update user1 set name = ? where id = ?", new Object[][]{{"fan1",1},{"fan2",2}});
		for (int i : batch) {
			System.out.println(1);
		}
	}
	
	/**
	 * 查询操作，查询结果为多个
	 * @throws SQLException 
	 */
	@Test
	public void selectManyTest() throws SQLException {
		QueryRunner qr = new QueryRunner(c3p0Util.getDataSource());
		List<Account> list = qr.query("select * from account",new ResultSetHandler<List<Account>>() {

			@Override
			public List<Account> handle(ResultSet rs) throws SQLException {
				ArrayList<Account> list = new ArrayList<>();
				while(rs.next()) {
					Account a = new Account();
					a.setId(rs.getInt("id"));
					a.setName(rs.getString("name"));
					a.setMoney(rs.getInt("money"));
					list.add(a);
				}
				return list;
			}
			
		});
		for (Account account : list) {
			System.out.println(account);
		}
		
	}
	
	/**
	 * 查询操作:查询结果为单个
	 * @throws SQLException 
	 */
	@Test
	public void selectTest() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		Account account = queryRunner.query("select * from account where id = ?", new ResultSetHandler<Account>() {

			@Override
			public Account handle(ResultSet rs) throws SQLException {
				Account acc = new Account();
				while(rs.next()) {
				
				acc.setId(rs.getInt("id"));
				acc.setName(rs.getString("name"));
				acc.setMoney(rs.getInt("money"));
				}
				return acc;
			}
			
		},120);
		System.out.println(account);
	}
	
	/**
	 * 查询操作处理结果集之
	 * ArrayHandle 
	 */
	@Test
	public void arrayHandleTest() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		Object[] array = queryRunner.query("select * from account where id = ?", new ArrayHandler(),1);
		System.out.println(Arrays.toString(array));
	}
	/**
	 * 查询操作处理结果集之
	 * ArrayListHandle 
	 */
	@Test
	public void arrayListHandleTest() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		List<Object[]> list = queryRunner.query("select * from account", new ArrayListHandler());
		for (Object[] array : list) {
			System.out.println(Arrays.toString(array));
		}
	}
	
	/**
	 * 查询操作处理结果集之
	 * BeanHandle 
	 */
	@Test
	public void BeanHandleTest() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		Object account = queryRunner.query("select * from account where id = ?", new BeanHandler(Account.class),1);
		System.out.println(account);
	}
	
	/**
	 * 查询操作处理结果集之
	 * BeanListHandle 
	 */
	@Test
	public void BeanListHandleTest() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		List<Account> list = queryRunner.query("select * from account1", new BeanListHandler<>(Account.class));
		for (Account account : list) {
			System.out.println(account);	
		}
	}
	
	/**
	 * 查询操作处理结果集之
	 * MapHandle 
	 */
	@Test
	public void MapHandleTest() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		Map<String, Object> map = queryRunner.query("select * from account where id = ?", new MapHandler(),1);
		System.out.println(map);
	}
	
	/**
	 * 查询操作处理结果集之
	 * MapListHandle 
	 */
	@Test
	public void MapListHandleTest() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		List<Map<String,Object>> query = queryRunner.query("select * from account1", new MapListHandler());
		for (Map<String, Object> map : query) {
			System.out.println(map);
		}
	}
	
	/**
	 * 查询操作处理结果集之
	 * ColumeHandle 
	 */
	@Test
	public void ColumeHandleTest() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		List<Object> list = queryRunner.query("select * from account where id > ?", new ColumnListHandler("name"),1);
		for (Object object : list) {
			System.out.println(object);
		}
	}
	
	/**
	 * 查询操作处理结果集之
	 * ColumeHandle 
	 */
	@Test
	public void ScalarHandleTest() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		Object query = queryRunner.query("select max(money) from account", new ScalarHandler());
		System.out.println(query);
	}
	
	/**
	 * 查询操作处理结果集之
	 * KeyedHandle 
	 */
	@Test
	public void KeyedHandleTest() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		Map<Object, Map<String, Object>> map = queryRunner.query("select * from account", new KeyedHandler(2));
		
		Set<Object> keySet = map.keySet();
		for (Object object : keySet) {
			System.out.println(object +"   "+map.get(object));
		}
		
	}
}

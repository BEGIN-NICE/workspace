package com.itheima.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.junit.Test;

import com.itheima.jdbc.utils.JDBCUtils;
import com.itheima.自定义连接池.MyDataSource;
import com.itheima.自定义连接池.MyDataSource2;

public class 自定义连接池Test {
	/**
	 * 采用装饰则模设计
	 */
	@Test
	public void demo2() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DataSource myDataSource = null;
		try {
		myDataSource = new MyDataSource2();
		
		System.out.println(((MyDataSource2) myDataSource).getList().size());
		
		conn = myDataSource.getConnection();
		
		System.out.println(((MyDataSource2) myDataSource).getList().size());
		String sql = "select name from user1 where id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, 2);
		rs = pstmt.executeQuery();
		if(rs.next())
			System.out.println(rs.getString("name"));
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(rs, pstmt, conn);
			System.out.println(((MyDataSource2) myDataSource).getList().size());
		}
	}
	
	/**
	 * 不再用装饰则模式
	 */
	@Test
	public void demo1() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MyDataSource myDataSource = null;
		try {
		myDataSource = new MyDataSource();
		conn = myDataSource.getConnection();
		String sql = "select name from user1 where id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, 2);
		rs = pstmt.executeQuery();
		if(rs.next())
			System.out.println(rs.getString("name"));
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null)
			myDataSource.addBack(conn);
		}
	}
}

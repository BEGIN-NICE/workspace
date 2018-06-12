package com.itheima.c3p0;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.junit.Test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.itheima.jdbc.utils.JDBCUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Test {
	
	/**
	 * 使用配置文件的方式来使用c3p0
	 * @throws SQLException
	 */
	@Test
	public void c3p0Demo02() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//通过配置文件获得DataSource的代码
			//只要已创建连接池，默认去类路径下查找c3p0-config.xml文件
			ComboPooledDataSource dataSource = new ComboPooledDataSource();
			
			conn = dataSource.getConnection();
			String sql = "select name from user1 where id =  ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 2);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("name"));
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(rs, pstmt, conn);
		}
	}
	
	/**
	 * 
	 * 手动设置参数使用c3p0
	 * @throws SQLException
	 */
	@Test
	public void c3p0Demo01() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			ComboPooledDataSource dataSource = new ComboPooledDataSource();
//			ComboPooledDataSource dataSource2 = new ComboPooledDataSource();
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mysql:///heima");
			dataSource.setUser("root");
			dataSource.setPassword("root");
			conn = dataSource.getConnection();
			String sql = "select name from user1 where id =  ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 2);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("name"));
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(rs, pstmt, conn);
		}
	}
}

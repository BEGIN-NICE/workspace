package com.itheima.druid;

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

public class TruidTest {
	
	/**
	 * 使用配置文件的方式来使用Druid
	 * @throws SQLException
	 */
	@Test
	public void truidDemo02() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//通过配置文件获得DataSource的代码
			Properties properties = new Properties();
			
			properties.load(new FileInputStream("src/druid.properties"));
			
			DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
			
			
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
	 * 手动设置参数使用Druid
	 * @throws SQLException
	 */
	@Test
	public void truidDemo01() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			DruidDataSource dataSource = new DruidDataSource();
			dataSource.setDriverClassName("com.mysql.jdbc.Driver");
			dataSource.setUrl("jdbc:mysql:///heima");
			dataSource.setUsername("root");
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

package com.itheima.druid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.alibaba.druid.pool.DruidDataSource;
import com.itheima.jdbc.utils.JDBCUtils;

public class Druid手动连接数据库Test {
	@Test
	public void druidTest() {
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
			 conn.setAutoCommit(false);
			 String sql = "select * from user1";
			 pstmt = conn.prepareStatement(sql);
			 rs = pstmt.executeQuery();
			 while(rs.next()) {
				 System.out.println(rs.getInt(1)+"=="+rs.getString(2));
			 }
			 conn.commit();
		}catch(Exception e) {
			if(conn != null)
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			
			e.printStackTrace();
		}finally {
			JDBCUtils.release(rs, pstmt, conn);
		}
	}
}

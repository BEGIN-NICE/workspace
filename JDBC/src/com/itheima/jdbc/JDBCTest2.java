package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.jdbc.util.JDBCUtil;

public class JDBCTest2 {
	@Test
	public void selectTest() throws SQLException {
		Connection conn = JDBCUtil.getConnection();
		String sql = "select * from account where id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, 2);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString("name"));
		}
		JDBCUtil.closeAll(rs, ps, conn);
	}
	
}

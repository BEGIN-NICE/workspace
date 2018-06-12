package com.itheima.jdbc.preparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.jdbc.util.JDBCUtil;

public class PreparedStatementCURD {
	@Test
	public void selectTest() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from user1 where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 2);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getInt("id")+ " "+rs.getString("name"));

			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(rs,pstmt,conn);
		}
	}
	@Test
	public void deleteTest() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JDBCUtil.getConnection();
		String sql = "delete from user1 where id > ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, 10);
		int update = pstmt.executeUpdate();
		if(update>0) {
			System.out.println("É¾³ý³É¹¦"+"update = "+update);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(pstmt, conn);
		}
	}
}

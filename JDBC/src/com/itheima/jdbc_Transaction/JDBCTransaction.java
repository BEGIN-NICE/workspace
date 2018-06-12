package com.itheima.jdbc_Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import com.jdbc.util.JDBCUtil;

public class JDBCTransaction {
	@Test
	public void transactionTest() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JDBCUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "update account1 set money = money + ? where id = ?";
			pstmt  = conn.prepareStatement(sql);
			pstmt.setInt(1, -1000);
			pstmt.setInt(2, 1);
			pstmt.executeUpdate();
			
//			int i = 1/0;
			
			pstmt.setInt(1, 1000);
			pstmt.setInt(2, 2);
			pstmt.executeUpdate();
			
			conn.commit();
			
		}catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(pstmt, conn);
		}
	}
}

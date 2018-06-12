package com.ithema.jdbc_addBatch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jdbc.util.JDBCUtil;

public class AddBatchTest2 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "insert into user1 values (null,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "fanxh1");
			pstmt.addBatch();
			pstmt.setString(1, "fanxh2");
			pstmt.addBatch();
			pstmt.executeBatch();
			pstmt.clearBatch();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(rs, pstmt, conn);
		}
	}
}

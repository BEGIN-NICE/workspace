package com.ithema.jdbc_addBatch;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import com.jdbc.util.JDBCUtil;

public class AddBatchTest {
	@Test
	public void abTest() {
		Connection conn = null;
		PreparedStatement pstmt  = null;
		try {
			long start = System.currentTimeMillis();
			conn = JDBCUtil.getConnection();
			String sql = "insert into user1 value (null,?)";
			pstmt = conn.prepareStatement(sql);
			for(int i = 1000;i<=10000;i++) {
				pstmt.setString(1, "aaa"+i);
				pstmt.addBatch();
				if(i%1000==0) {
					pstmt.executeBatch();
					pstmt.clearBatch();	
				}
				
			}
			long end  = System.currentTimeMillis();
			System.out.println((end - start)/1000);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(pstmt, conn);
		}
		
	}
	
}

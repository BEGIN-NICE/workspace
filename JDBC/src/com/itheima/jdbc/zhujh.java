package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import com.jdbc.util.JDBCUtil;

public class zhujh {
	@Test
	public void test1() {
	Connection conn = null;
	PreparedStatement ps = null;
	try {
		conn = JDBCUtil.getConnection();
		String sql = "insert into user1 values(null,?)";
		ps = conn.prepareStatement(sql);
		for (int i = 1; i <100; i++) {

			ps.setString(1, "name" + i);
			ps.addBatch();
			if (i % 10 == 0) {
				ps.executeBatch();
				ps.clearBatch();
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		JDBCUtil.closeAll(ps, conn);
	}
	System.out.println("ÍêÊÂ");
}
}

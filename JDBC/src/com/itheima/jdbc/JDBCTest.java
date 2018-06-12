package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.jdbc.util.JDBCUtil;

public class JDBCTest {
	@Test
	public void jdbcTest() throws SQLException {
		Connection con = JDBCUtil.getConnection();
		Statement statement = con.createStatement();
		String sql = "select * from account ";
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			System.out.print(rs.getInt("id") + " ");
			System.out.print(rs.getString("name") + " ");
			System.out.print(rs.getInt("money") + " ");
			System.out.println();
		}
		JDBCUtil.closeAll(rs, statement, con);
	}

	@Test
	public void addTest() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql:///heima", "root", "root");
		System.out.println(con);
		Statement statement = con.createStatement();
		String sql = "insert into account values (null,'张伟',100)";
		int num = statement.executeUpdate(sql);
		if (num > 0) {
			System.out.println("数据保存成功");
		}

		statement.close();
		con.close();
	}

	@Test
	public void updateTest() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql:///heima", "root", "root");
			System.out.println(conn);
			statement = conn.createStatement();
			String sql = "update account set name = '旺财' where id = 4";
			int num = statement.executeUpdate(sql);
			if (num > 0) {
				System.out.println("数据修改成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				statement.close();
			}
			statement = null;
			if (conn != null) {
				conn.close();
			}
			conn = null;
		}

	}

	@Test
	public void deleteTest() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql:///heima", "root", "root");
			System.out.println(conn);
			statement = conn.createStatement();
			String sql = "delete from account where id = 4";
			int num = statement.executeUpdate(sql);
			if (num > 0) {
				System.out.println("数据删除成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				statement.close();
			}
			statement = null;
			if (conn != null) {
				conn.close();
			}
			conn = null;
		}

	}

	@Test
	public void selectTest() {
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql:///heima", "root", "root");
			System.out.println(conn);
			statement = conn.createStatement();
			String sql = "select * from account";
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getInt("money"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			rs = null;
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			statement = null;
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			conn = null;
		}

	}
}

package com.itheima.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class c3p0Util {
	private static final ComboPooledDataSource DATA_SOURCE = new ComboPooledDataSource();
	private static final ThreadLocal<Connection> t = new ThreadLocal<>();
	public static Connection getConnection() throws SQLException {
		Connection conn = t.get();
		if(conn == null) {
			conn = DATA_SOURCE.getConnection();
			t.set(conn);
		}
		return conn;
	}
	
	public static DataSource getDataSource() {
		return DATA_SOURCE;
	}
}

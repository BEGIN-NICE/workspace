package com.itheima.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//为每个线程绑定连接
public class c3p0Util {
	private static final ComboPooledDataSource DATA_SOURCE = new ComboPooledDataSource();
	private static final ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	public static Connection getConnection() throws SQLException {
		Connection conn = tl.get();
		if(conn==null) {
			conn = DATA_SOURCE.getConnection();
			tl.set(conn);
		}
		return conn;
	}
	
	public static DataSource getDataSource() {
		return DATA_SOURCE;
	}
}

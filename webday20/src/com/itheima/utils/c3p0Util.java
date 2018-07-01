package com.itheima.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class c3p0Util {
	private static final ComboPooledDataSource DATA_SOURCE = new ComboPooledDataSource();
	public static Connection getConnection() throws SQLException {
		Connection conn = DATA_SOURCE.getConnection();
		return conn;
	}
	
	public static DataSource getDataSource() {
		return DATA_SOURCE;
	}
}

package com.itheima.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtil {
	private static final DataSource DATA_SOURCE = new ComboPooledDataSource();

	public static DataSource getDataSource() {

		return DATA_SOURCE;
	}

	public static Connection getConnection() {

		try {
			return DATA_SOURCE.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}

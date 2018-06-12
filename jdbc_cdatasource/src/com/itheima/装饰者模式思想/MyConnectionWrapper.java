package com.itheima.装饰者模式思想;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MyConnectionWrapper extends ConnectionWrapper {
	private Connection conn;
	private List<Connection> list;
	
	public MyConnectionWrapper(Connection conn,List<Connection> list) {
		super(conn);
		this.conn = conn;
		this.list = list;
	}
	
	@Override
	public void close() throws SQLException {
		list.add(conn);
	}
}

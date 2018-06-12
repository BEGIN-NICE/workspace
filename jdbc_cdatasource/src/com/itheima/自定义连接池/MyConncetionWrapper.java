package com.itheima.自定义连接池;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MyConncetionWrapper extends ConnectionWrapper {
	private Connection conn;
	private List<Connection> list;
	public MyConncetionWrapper(Connection conn , List<Connection> list) {
		super(conn);
		this.conn  = conn;
		this.list = list;
	}
	
	@Override
	public void close() throws SQLException {		
//		super.close();
		list.add(conn);
	}

}

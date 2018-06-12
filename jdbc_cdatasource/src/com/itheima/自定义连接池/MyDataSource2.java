package com.itheima.自定义连接池;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

import com.itheima.jdbc.utils.JDBCUtils;

/**
 * 没有采用装饰者模式，
 * @author fanxh
 *
 */
public class MyDataSource2 implements DataSource {
	private List<Connection> connections = new ArrayList<Connection>();
	public MyDataSource2() {
		for(int i =0;i < 3; i ++) {
			connections.add(JDBCUtils.getConnection());
		}
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		MyConncetionWrapper myConncetionWrapper = new MyConncetionWrapper(connections.remove(0), connections);
		return myConncetionWrapper;
	}

	public List getList() {
		return connections;
	}
	
//	public void addBack(Connection conn) {
//		connections.add(conn);
//	}
//	
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isWrapperFor(Class<?> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
}

package com.itheima.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.itheima.domain.Account;
import com.itheima.utils.c3p0Util;

public class AccountDao {

	public void fromAccount(Account account) throws SQLException {
		Connection conn = c3p0Util.getConnection();
		String sql = "update account set money = money - ? where name = ?";
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setDouble(1, account.getMoney());
		pstat.setString(2, account.getFrom());
		pstat.executeUpdate();
	}

	public void toAccount(Account account) throws SQLException {
		Connection conn = c3p0Util.getConnection();
		String sql = "update account set money = money + ? where name = ?";
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setDouble(1, account.getMoney());
		pstat.setString(2, account.getTo());
		pstat.executeUpdate();
		
	}

}

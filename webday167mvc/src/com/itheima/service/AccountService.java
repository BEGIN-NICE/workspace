package com.itheima.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.utils.c3p0Util;

public class AccountService {

	//ͨ��Connection���Ӱ󶨵���ǰ�̵߳ķ�ʽ�����������
	public void account(Account account) throws SQLException {
		AccountDao accountDao = new AccountDao();
		Connection conn = c3p0Util.getConnection();
		conn.setAutoCommit(false);
		accountDao.fromAccount(account);
		int i = 10/0;
		accountDao.toAccount(account);
		conn.commit();
		
		
	}

}

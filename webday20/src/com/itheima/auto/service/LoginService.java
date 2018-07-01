package com.itheima.auto.service;

import java.sql.SQLException;

import com.itheima.auto.dao.LoginDao;
import com.itheima.auto.domain.User;

public class LoginService {

	public User login(User user) throws SQLException {
		LoginDao loginDao = new LoginDao();
		return loginDao.login(user);
	}

}

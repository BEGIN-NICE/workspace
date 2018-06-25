package com.itheima.service;

import java.sql.SQLException;

import com.itheima.dao.LoginDao;
import com.itheima.domain.User;

public class LoginService {

	public User checkUser(User user) throws SQLException {
		LoginDao loginDao = new LoginDao();
		return loginDao.checkUsername(user);
	}
	
	public User checkUserpassword(User user) throws SQLException {
		LoginDao loginDao = new LoginDao();
		return loginDao.checkUserpassword(user);
	}

}

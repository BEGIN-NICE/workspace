package com.demo.service.impl;

import java.sql.SQLException;

import com.demo.dao.UserDao;
import com.demo.dao.impl.UserDaoImpl;
import com.demo.domain.User;
import com.demo.service.UserService;

public class UserServiceImpl implements UserService{

	@Override
	public User findUser(String username, String password) throws SQLException {
		UserDao userDao = new UserDaoImpl();
		return userDao.findUser(username,password);
	}

}

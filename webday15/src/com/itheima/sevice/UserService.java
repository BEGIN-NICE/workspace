package com.itheima.sevice;

import java.sql.SQLException;

import com.itheima.bean.User;
import com.itheima.dao.UserDao;

public class UserService {

	public void registerUser(User user) throws SQLException {
		UserDao userDao = new UserDao();
		userDao.registerUser(user);
	}

}

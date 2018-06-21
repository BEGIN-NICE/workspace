package com.itheima.sevice;

import java.sql.SQLException;

import com.itheima.bean.User;
import com.itheima.dao.UserDao;
import com.itheima.dao.UserLoginDao;

public class UserLoginService {
	public User login(User user) {
		UserLoginDao userLoginDao = new UserLoginDao();
		User login = null;
		try {
			login = userLoginDao.login(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return login;
	}
}

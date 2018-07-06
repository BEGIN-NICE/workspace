package com.itheima.store.service.impl;

import java.sql.SQLException;

import com.itheima.store.dao.UserDao;
import com.itheima.store.dao.impl.UserDaoImpl;
import com.itheima.store.domain.User;
import com.itheima.store.service.UserService;
import com.itheima.store.utils.BeanFactory;
import com.itheima.store.utils.MailUtil;

public class UserServiceImpl implements UserService {

	@Override
	public User findByUsername(String username) throws SQLException {
		UserDao userDao = (UserDaoImpl)BeanFactory.getBean("userDaoImpl");
		return userDao.findByUsername(username);
	}

	@Override
	public void save(User user) throws SQLException {
		UserDao userDao = (UserDaoImpl)BeanFactory.getBean("userDaoImpl");
		// ·¢ËÍÓÊ¼þ
		MailUtil.sendMail(user.getEmail(), user.getCode());
		userDao.save(user);
	}

	@Override
	public User findByCode(String code) throws SQLException {
		UserDao userDao = (UserDaoImpl)BeanFactory.getBean("userDaoImpl");
		return userDao.findByCode(code);
	}

	@Override
	public void update(User existUser) throws SQLException {
		UserDao userDao = (UserDaoImpl)BeanFactory.getBean("userDaoImpl");
		userDao.update(existUser);
	}

	@Override
	public User login(User user) throws SQLException {
		UserDao userDao = (UserDaoImpl)BeanFactory.getBean("userDaoImpl");
		return userDao.login(user);
	}

}

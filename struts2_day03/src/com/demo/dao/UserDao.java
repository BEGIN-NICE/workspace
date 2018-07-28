package com.demo.dao;

import java.sql.SQLException;

import com.demo.domain.User;

public interface UserDao {

	User findUser(String username, String password) throws SQLException;

}

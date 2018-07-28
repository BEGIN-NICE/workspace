package com.demo.service;

import java.sql.SQLException;

import com.demo.domain.User;

public interface UserService {

	User findUser(String username, String password) throws SQLException;

}

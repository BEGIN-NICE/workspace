package com.itheima.product.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.product.dao.AboutInfoDao;

public class AboutInfoService {

	public List<String> aboutInfo(String info) throws SQLException {
		AboutInfoDao aboutInfoDao = new AboutInfoDao();
		
		
		return aboutInfoDao.aboutInfo(info);
	}

}

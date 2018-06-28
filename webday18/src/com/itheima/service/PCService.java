package com.itheima.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.dao.PCDao;
import com.itheima.domain.City;
import com.itheima.domain.Province;

public class PCService {

	public List<Province> findProvince() throws SQLException {
		PCDao pcDao = new PCDao();
		return pcDao.findProvince();
	}

	public List<City> findCityBypId(String pid) throws SQLException {
		PCDao pcDao = new PCDao();
		return pcDao.findCityBypId(pid);
	}

}

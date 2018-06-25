package com.itheima.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.dao.SearchDao;
import com.itheima.domain.Word;

public class SearchService {

	public List<Word> search(String info) throws SQLException {
		SearchDao searchDao = new SearchDao();
		return searchDao.search(info);
	}

}

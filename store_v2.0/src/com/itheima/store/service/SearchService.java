package com.itheima.store.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.store.domain.PageBean;
import com.itheima.store.domain.Product;

public interface SearchService {

	PageBean findByPname(String search, int currpage) throws SQLException;

}

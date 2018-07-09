package com.itheima.store.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.itheima.store.dao.ProductDao;
import com.itheima.store.dao.SearchDao;
import com.itheima.store.dao.impl.ProductDaoImpl;
import com.itheima.store.domain.PageBean;
import com.itheima.store.domain.Product;
import com.itheima.store.service.SearchService;
import com.itheima.store.utils.BeanFactory;

public class SearchServiceImpl implements SearchService {

	@Override
	public PageBean findByPname(String search,int currpage) throws SQLException {
		
		PageBean pageBean = new PageBean();
		//当前页
		pageBean.setCurrPage(currpage);
		//每页数据条数
		int pageSize = 12;
		pageBean.setPageSize(pageSize);
		//每页商品数据
		SearchDao searchDao = (SearchDao) BeanFactory.getBean("searchDao");
		List<Product> list = searchDao.findByPname(search);
		pageBean.setList(list);
		//中数据条数
		int count = searchDao.findCountByPname(search);
		pageBean.setTotalCount(count);
		//总页数
		Double ceil = Math.ceil((double)count/pageSize);
		pageBean.setTotalPage(ceil.intValue());
		
		return pageBean;
	}


}

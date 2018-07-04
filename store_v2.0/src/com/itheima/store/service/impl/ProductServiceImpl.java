package com.itheima.store.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.itheima.store.dao.ProductDao;
import com.itheima.store.dao.impl.ProductDaoImpl;
import com.itheima.store.domain.PageBean;
import com.itheima.store.domain.Product;
import com.itheima.store.service.ProductService;

public class ProductServiceImpl implements ProductService{

	@Override
	public List<Product> findByHot() throws SQLException{
		ProductDao productDao = new ProductDaoImpl();
		return productDao.findByHot();
	}

	@Override
	public List<Product> findByNew() throws SQLException{
		ProductDao productDao = new ProductDaoImpl();
		return productDao.findByNew();
	}

	@Override
	public PageBean findByCid(String cid, Integer currPage) throws SQLException {
		PageBean pageBean = new PageBean();
		//当前页
		pageBean.setCurrPage(currPage);
		//每页数据条数
		int pageSize = 12;
		pageBean.setPageSize(pageSize);
		//每页商品数据
		ProductDao productDao = new ProductDaoImpl();
		List<Product> list = productDao.findByCid(cid,pageSize,currPage);
		pageBean.setList(list);
		//中数据条数
		Integer count = productDao.findCountByCid(cid);
		pageBean.setTotalCount(count);
		//总页数
		Double ceil = Math.ceil((double)count/pageSize);
		pageBean.setTotalPage(ceil.intValue());
		
		return pageBean;
	}

	@Override
	public Product findByPid(String pid) throws SQLException {
		ProductDao productDao = new ProductDaoImpl();
		
		return productDao.findByPid(pid);
	}

}

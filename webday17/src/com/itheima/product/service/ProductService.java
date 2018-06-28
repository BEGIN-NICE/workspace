package com.itheima.product.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.itheima.product.dao.ProductDao;
import com.itheima.product.domain.PageBean;
import com.itheima.product.domain.Product;
import com.itheima.utils.c3p0Util;

public class ProductService {
	/**
	 * 查询所有商品信息
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Product> findAll() throws SQLException {
		ProductDao productDao = new ProductDao();

		return productDao.findAll();
	}

	/**
	 * 查询单个商品信息然后进行修改
	 * 
	 * @param pid
	 * @return
	 * @throws SQLException
	 */
	public Product find(String pid) throws SQLException {
		ProductDao productDao = new ProductDao();
		return productDao.find(pid);
	}

	/**
	 * 修改商品信息
	 * 
	 * @param product
	 * @throws SQLException
	 */
	public void edit(Product product) throws SQLException {
		ProductDao productDao = new ProductDao();
		productDao.edit(product);
	}

	/**
	 * 删除商品
	 * 
	 * @throws SQLException
	 */
	public void delete(String pid) throws SQLException {
		ProductDao productDao = new ProductDao();
		productDao.delete(pid);
	}

	/**
	 * 模糊查询商品
	 * 
	 * @param pname
	 * @return
	 * @throws SQLException
	 */
	public List<Product> search(String pname) throws SQLException {
		ProductDao productDao = new ProductDao();
		return productDao.search(pname);

	}

	/**
	 * 批量删除
	 * 
	 * @param ids
	 */
	public void deleteAll(String[] ids) {
		Connection conn = null;
		try {
			conn = c3p0Util.getConnection();
			conn.setAutoCommit(false);
			ProductDao productDao = new ProductDao();
			for (String id : ids) {
				productDao.deleteAll(conn,id);
			}
			DbUtils.commitAndCloseQuietly(conn);
		} catch (Exception e) {
			DbUtils.rollbackAndCloseQuietly(conn);
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

	/**
	 * 分页查询
	 * @param strCurrPage
	 * @return
	 * @throws SQLException 
	 */
	public PageBean findByPage(String strCurrPage) throws SQLException {
		//数据封装
		PageBean pageBean = new PageBean();
		int currPage = Integer.parseInt(strCurrPage);
		//总的数据条数
		ProductDao productDao = new ProductDao();
		Double totalCount = productDao.findCount();
		//每页数据
		int pageSize = 10;
		//总的页数
		int totalPage = (int)Math.ceil(totalCount/pageSize);

		List<Product> list =  productDao.findPageList((currPage-1)*10,pageSize);
		pageBean.setCurrPage(currPage);
		pageBean.setTotalPage(totalPage);
		pageBean.setTotalCount(totalCount);
		pageBean.setPageSize(pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	
	
	/**
	 * 分页查询2
	 * @param strCurrPage
	 * @return
	 * @throws SQLException 
	 */
	public PageBean findByPage2(String strCurrPage,String strPageSize) throws SQLException {
		//数据封装
		PageBean pageBean = new PageBean();
		int currPage = Integer.parseInt(strCurrPage);
		//总的数据条数
		ProductDao productDao = new ProductDao();
		Double totalCount = productDao.findCount();
		//每页数据
		int pageSize;
		if(strPageSize==null||Integer.parseInt(strPageSize)>totalCount.intValue()) {
			pageSize =10;
		}else {
			pageSize = Integer.parseInt(strPageSize);
		}
		//总的页数
		int totalPage = (int)Math.ceil(totalCount/pageSize);

		List<Product> list =  productDao.findPageList((currPage-1)*10,pageSize);
		pageBean.setCurrPage(currPage);
		pageBean.setTotalPage(totalPage);
		pageBean.setTotalCount(totalCount);
		pageBean.setPageSize(pageSize);
		pageBean.setList(list);
		return pageBean;
	}

}

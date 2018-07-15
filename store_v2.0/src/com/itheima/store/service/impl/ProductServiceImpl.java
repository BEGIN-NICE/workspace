package com.itheima.store.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.itheima.store.dao.ProductDao;
import com.itheima.store.dao.impl.ProductDaoImpl;
import com.itheima.store.domain.Image;
import com.itheima.store.domain.Orders;
import com.itheima.store.domain.PageBean;
import com.itheima.store.domain.Product;
import com.itheima.store.service.ProductService;
import com.itheima.store.utils.BeanFactory;
import com.itheima.store.utils.c3p0Util;

public class ProductServiceImpl implements ProductService{

	@Override
	public List<Product> findByHot() throws SQLException{
		ProductDao productDao = (ProductDaoImpl)BeanFactory.getBean("productDaoImpl");
		return productDao.findByHot();
	}

	@Override
	public List<Product> findByNew() throws SQLException{
		ProductDao productDao = (ProductDaoImpl)BeanFactory.getBean("productDaoImpl");
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
		ProductDao productDao = (ProductDaoImpl)BeanFactory.getBean("productDaoImpl");
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
		ProductDao productDao = (ProductDaoImpl)BeanFactory.getBean("productDaoImpl");
		
		return productDao.findByPid(pid);
	}

	@Override
	public int getCount() throws SQLException {
		ProductDao productDao = (ProductDaoImpl)BeanFactory.getBean("productDaoImpl");
		
		return productDao.getCount();
	}

	@Override
	public PageBean findAllByPage(String currPageStr) throws SQLException {

		PageBean<Product> pageBean = new PageBean<Product>();
		
		Integer currPage;
		if(currPageStr==null) {
			currPage=1;
		}else {
			currPage = Integer.parseInt(currPageStr);
		}
		pageBean.setCurrPage(currPage);
		
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		
		int begin = (currPage-1)*pageSize;
		ProductDao productDao = (ProductDao) BeanFactory.getBean("productDaoImpl");
		int totalCount = productDao.getCount();
		pageBean.setTotalCount(totalCount);
		
		List<Product> list = productDao.findAllByPage(begin,pageSize);
		pageBean.setList(list);
		
		Double totalPage = Math.ceil((double)totalCount/pageSize);
		pageBean.setTotalPage(totalPage.intValue());
		return pageBean;
	}

//	@Override
//	public void save(Product product) throws SQLException {
//		ProductDao productDao = (ProductDao) BeanFactory.getBean("productDaoImpl");
//		productDao.save(product);
//	}
//修改后	
	@Override
	public void save(Image image) throws SQLException {
		ProductDao productDao = (ProductDao) BeanFactory.getBean("productDaoImpl");
		productDao.save(image);
	}

	@Override
	public void pushDown(String pid) throws SQLException {
		ProductDao productDao = (ProductDao) BeanFactory.getBean("productDaoImpl");
		productDao.pushDown(pid);
	}

	@Override
	public PageBean findAllByPushDown(String currPageStr) throws SQLException {
PageBean<Product> pageBean = new PageBean<Product>();
		
		Integer currPage;
		if(currPageStr==null) {
			currPage=1;
		}else {
			currPage = Integer.parseInt(currPageStr);
		}
		pageBean.setCurrPage(currPage);
		
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		
		int begin = (currPage-1)*pageSize;
		ProductDao productDao = (ProductDao) BeanFactory.getBean("productDaoImpl");
		int totalCount = productDao.getCountPushDown();
		pageBean.setTotalCount(totalCount);
		
		List<Product> list = productDao.findAllByPushDown(begin,pageSize);
		pageBean.setList(list);
		
		Double totalPage = Math.ceil((double)totalCount/pageSize);
		pageBean.setTotalPage(totalPage.intValue());
		return pageBean;
	}

	@Override
	public void update(Product product) throws SQLException {
		ProductDao productDao = (ProductDao) BeanFactory.getBean("productDaoImpl");
		productDao.update(product);
	}

	@Override
	public Image findImageByPid(String pid) throws SQLException {
		ProductDao productDao = (ProductDao) BeanFactory.getBean("productDaoImpl");
		return productDao.findImageByPid(pid);
	}

	@Override
	public void update(Image image) {
		Connection conn=null;
		try {
			conn = c3p0Util.getConnection();
			conn.setAutoCommit(true);
			ProductDao productDao = (ProductDao) BeanFactory.getBean("productDaoImpl");
			productDao.update(image,conn);
			DbUtils.commitAndCloseQuietly(conn);
		}catch(Exception e) {
			if(conn!=null) {
				DbUtils.rollbackAndCloseQuietly(conn);
			}
			e.printStackTrace();
		}
	}

	

}

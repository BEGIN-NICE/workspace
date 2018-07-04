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
		//��ǰҳ
		pageBean.setCurrPage(currPage);
		//ÿҳ��������
		int pageSize = 12;
		pageBean.setPageSize(pageSize);
		//ÿҳ��Ʒ����
		ProductDao productDao = new ProductDaoImpl();
		List<Product> list = productDao.findByCid(cid,pageSize,currPage);
		pageBean.setList(list);
		//����������
		Integer count = productDao.findCountByCid(cid);
		pageBean.setTotalCount(count);
		//��ҳ��
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

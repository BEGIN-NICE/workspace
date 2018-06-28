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
	 * ��ѯ������Ʒ��Ϣ
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Product> findAll() throws SQLException {
		ProductDao productDao = new ProductDao();

		return productDao.findAll();
	}

	/**
	 * ��ѯ������Ʒ��ϢȻ������޸�
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
	 * �޸���Ʒ��Ϣ
	 * 
	 * @param product
	 * @throws SQLException
	 */
	public void edit(Product product) throws SQLException {
		ProductDao productDao = new ProductDao();
		productDao.edit(product);
	}

	/**
	 * ɾ����Ʒ
	 * 
	 * @throws SQLException
	 */
	public void delete(String pid) throws SQLException {
		ProductDao productDao = new ProductDao();
		productDao.delete(pid);
	}

	/**
	 * ģ����ѯ��Ʒ
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
	 * ����ɾ��
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
	 * ��ҳ��ѯ
	 * @param strCurrPage
	 * @return
	 * @throws SQLException 
	 */
	public PageBean findByPage(String strCurrPage) throws SQLException {
		//���ݷ�װ
		PageBean pageBean = new PageBean();
		int currPage = Integer.parseInt(strCurrPage);
		//�ܵ���������
		ProductDao productDao = new ProductDao();
		Double totalCount = productDao.findCount();
		//ÿҳ����
		int pageSize = 10;
		//�ܵ�ҳ��
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
	 * ��ҳ��ѯ2
	 * @param strCurrPage
	 * @return
	 * @throws SQLException 
	 */
	public PageBean findByPage2(String strCurrPage,String strPageSize) throws SQLException {
		//���ݷ�װ
		PageBean pageBean = new PageBean();
		int currPage = Integer.parseInt(strCurrPage);
		//�ܵ���������
		ProductDao productDao = new ProductDao();
		Double totalCount = productDao.findCount();
		//ÿҳ����
		int pageSize;
		if(strPageSize==null||Integer.parseInt(strPageSize)>totalCount.intValue()) {
			pageSize =10;
		}else {
			pageSize = Integer.parseInt(strPageSize);
		}
		//�ܵ�ҳ��
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

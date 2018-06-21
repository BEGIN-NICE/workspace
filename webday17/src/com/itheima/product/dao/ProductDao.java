package com.itheima.product.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.itheima.product.domain.Product;
import com.itheima.utils.c3p0Util;

public class ProductDao {

	public List<Product> findAll() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "select * from product order by pdate desc";
		List<Product> list = queryRunner.query(sql, new BeanListHandler<Product>(Product.class));
		return list;
	}

	/**
	 * 查询要就修改的商品信息
	 * @param pid
	 * @return
	 * @throws SQLException 
	 */
	public Product find(String pid) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "select * from product where pid = ?";
		Product product = queryRunner.query(sql, new BeanHandler<Product>(Product.class),pid);
		return product;
	}

	/**
	 * 修改商品信息
	 * @param product
	 */
	public void edit(Product product) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "update product set pname=?,market_price=?,shop_price=?,is_hot=?,pdesc=?,pflag=?,cid=? where pid = ? ";
		Object[] param = {product.getPname(),product.getMarket_price(),product.getShop_price(),product.getIs_hot(),product.getPdesc(),product.getPflag(),product.getCid(),product.getPid()};
		queryRunner.update(sql, param);
	}

	/**
	 * 删除商品信息
	 * @param pid
	 * @throws SQLException
	 */
	public void delete(String pid) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "delete from product where pid = ?";
		queryRunner.update(sql, pid);
		
	}
	
	/**
	 * 模糊查询
	 * @param pname
	 * @return
	 * @throws SQLException
	 */
	public List<Product> search(String pname) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "select * from product where pname like ?";
		List<Product> list = queryRunner.query(sql, new BeanListHandler<Product>(Product.class),"%"+pname+"%");
		return list;
	}

	/**
	 * 批量删除，在业务层开启事物，
	 * @param conn
	 * @param id
	 * @throws SQLException 
	 */
	public void deleteAll(Connection conn, String id) throws SQLException {
		QueryRunner queryRunner = new QueryRunner();
		String sql = "delete from product where pid = ?";
		queryRunner.update(conn, sql, id);
	}

	/**
	 * 查询总的数据条数
	 * @return
	 * @throws SQLException 
	 */
	public Double findCount() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "select count(*) from product";
		Long count = (Long)queryRunner.query(sql, new ScalarHandler());
		return count.doubleValue();
	}

	/**
	 * 查询当前页的数据
	 * @param i
	 * @param pageSize
	 * @return
	 * @throws SQLException 
	 */
	public List<Product> findPageList(int i, int pageSize) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "select * from product order by pdate limit ?,?";
		List<Product> list = queryRunner.query(sql,new BeanListHandler<Product>(Product.class), i,pageSize);
		return list;
	}

}

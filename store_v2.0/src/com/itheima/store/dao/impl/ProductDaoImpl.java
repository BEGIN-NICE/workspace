package com.itheima.store.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.itheima.store.dao.ProductDao;
import com.itheima.store.domain.Orders;
import com.itheima.store.domain.Product;
import com.itheima.store.utils.c3p0Util;

public class ProductDaoImpl implements ProductDao {

	@Override
	public List<Product> findByHot() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "select * from product where pflag= ? and is_hot=? order by pdate desc limit ?";
		List<Product> list = queryRunner.query(sql, new BeanListHandler<Product>(Product.class),0,1,9);
		return list;
	}

	@Override
	public List<Product> findByNew() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "select * from product where pflag= ? order by pdate desc limit ?";
		List<Product> list = queryRunner.query(sql, new BeanListHandler<Product>(Product.class),0,9);
		return list;
	}

	@Override
	public List<Product> findByCid(String cid ,Integer pageSize,Integer currPage) throws SQLException {
		int begin = (currPage-1)*pageSize;
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "select * from product where pflag= ? and cid = ? order by pdate desc limit ?,?";
		List<Product> list = queryRunner.query(sql, new BeanListHandler<Product>(Product.class),0,cid,begin,pageSize);
		return list;
	}

	@Override
	public Integer findCountByCid(String cid) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "select count(*) from product where pflag= ? and cid = ?";
		Long l = (Long) queryRunner.query(sql, new ScalarHandler(),0,cid);
		return l.intValue();
	}

	@Override
	public Product findByPid(String pid) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "select * from product where pid = ?";
		Product query = queryRunner.query(sql, new BeanHandler<Product>(Product.class),pid);
		return query;
	}

	/**
	 * ºóÌ¨´úÂë
	 */
	@Override
	public int getCount() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "select count(*) from product where pflag=?";
		Long l = (Long) queryRunner.query(sql, new ScalarHandler(),0);
		return l.intValue();
	}

	@Override
	public List<Product> findAllByPage(int begin, int pageSize) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "select * from product where pflag=? order by pdate desc limit ?,?";
		List<Product> list = queryRunner.query(sql, new BeanListHandler<Product>(Product.class), 0,begin,pageSize);
		return list;
	}

	@Override
	public void save(Product product) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "insert into product values (?,?,?,?,?,?,?,?,?,?)";
		Object[] params = {product.getPid(),product.getPname(),product.getMarket_price(),product.getShop_price(),product.getPimage(),product.getPdate(),product.getIs_hot(),product.getPdesc(),product.getPflag(),product.getCategory().getCid()};
		queryRunner.update(sql, params);
	}

	@Override
	public void pushDown(String pid) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "update product set pflag=? where pid=?";
		queryRunner.update(sql, 1,pid);
		
	}

	@Override
	public List<Product> findAllByPushDown(int begin, int pageSize) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "select * from product where pflag=? order by pdate desc limit ?,?";
		List<Product> list = queryRunner.query(sql, new BeanListHandler<Product>(Product.class), 1,begin,pageSize);
		return list;
	}

	@Override
	public void update(Product p) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "update product set pname=?,market_price=?,shop_price=?,pimage=?,pdate=?,is_hot=?,pdesc=?,pflag=? where pid=?";
		Object[] params = {p.getPname(),p.getMarket_price(),p.getShop_price(),p.getPimage(),p.getPdate(),p.getIs_hot(),p.getPdesc(),p.getPflag(),p.getPid()};
		queryRunner.update(sql,params);
		
	}

	@Override
	public int getCountPushDown() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "select count(*) from product where pflag=?";
		Long l = (Long) queryRunner.query(sql, new ScalarHandler(),1);
		return l.intValue();
	}



}

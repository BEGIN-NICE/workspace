package com.itheima.product.dao;

import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;

import com.itheima.product.domain.Product;
import com.itheima.utils.c3p0Util;

public class ProductAddDao {
/**
 * 	private String pid;
	private String pname;
	private Double market_price;
	private Double shop_price;
	private String pimage;
	private Date pdate;
	private Double is_hot;
	private String pdesc;
	private Double pflag;
	private String cid;
 * @param product
 * @return
 * @throws SQLException 
 */
	public int addProduct(Product product) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "insert into product value (?,?,?,?,?,?,?,?,?,?)";
		int update = queryRunner.update(sql, product.getPid(),product.getPname(),product.getMarket_price(),
				product.getShop_price(),product.getPimage(),product.getPdate(),product.getIs_hot(),product.getPdesc()
				,product.getPflag(),product.getCid());
		return update;
	}

}

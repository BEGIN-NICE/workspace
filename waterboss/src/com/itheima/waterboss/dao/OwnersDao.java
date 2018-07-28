package com.itheima.waterboss.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.itheima.waterboss.entity.Owners;
/**
 * 业主信息数据访问类
 * @author fanxh
 *
 */
public class OwnersDao {
	/**
	 * 增加业主
	 * @param owners
	 */
	public static void add(Owners owners) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = BaseDao.getConnection();
			stmt = conn.prepareStatement("insert into T_OWNERS values (?,?,?,?,?,?,?)");
			stmt.setLong(1, owners.getId());
			stmt.setString(2, owners.getName());
			stmt.setLong(3, owners.getAddress());
			stmt.setString(4, owners.getHousenumber());
			stmt.setString(5, owners.getWatermeter());
			stmt.setDate(6, new Date(owners.getAdddate().getTime()) );
			stmt.setLong(7, owners.getOwnertypeid());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(11111);
		}finally {
			BaseDao.closeAll(null, stmt, conn);
		}
	}
	
	public static void update(Owners owners) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = BaseDao.getConnection();
			stmt = conn.prepareStatement("update t_owners set name=?,addressid=?,housenumber=?,watermeter=?,adddate=?,ownertypeid=? where id=?");
			
			stmt.setString(1, owners.getName());
			stmt.setLong(2, owners.getAddress());
			stmt.setString(3, owners.getHousenumber());
			stmt.setString(4, owners.getWatermeter());
			stmt.setDate(5, new Date(owners.getAdddate().getTime()) );
			stmt.setLong(6, owners.getOwnertypeid());
			stmt.setLong(7, owners.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			BaseDao.closeAll(null, stmt, conn);
		}
	}
	
	public static void delete(Owners owners) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = BaseDao.getConnection();
			stmt = conn.prepareStatement("delete from t_owners where id = ? ");		
			stmt.setLong(1, owners.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			BaseDao.closeAll(null, stmt, conn);
		}
	}
}

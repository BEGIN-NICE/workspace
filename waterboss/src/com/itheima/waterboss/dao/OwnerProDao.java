package com.itheima.waterboss.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.itheima.waterboss.entity.Owners;

import oracle.jdbc.OracleTypes;

/**
 * ʹ�ô洢����
 * @author fanxh
 *
 */
public class OwnerProDao {
	/**
	 * �����޴��������Ĵ洢����
	 * @param owner
	 */
	public static void add(Owners owner) {
		Connection conn = null;
		CallableStatement stmt = null;
		try {
			conn=BaseDao.getConnection();
			stmt = conn.prepareCall("{call pro_owner_add(?,?,?,?,?)}");
			stmt.setString(1, owner.getName());
			stmt.setLong(2, owner.getAddress());
			stmt.setString(3, owner.getHousenumber());
			stmt.setString(4, owner.getWatermeter());
			stmt.setLong(5, owner.getOwnertypeid());
			stmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			BaseDao.closeAll(null, stmt, conn);
		}
	}
	
	/**
	 * �����д��������Ĵ洢����
	 * @param owner
	 */
	public static Long add2(Owners owner) {
		Long id = 0L;
		Connection conn = null;
		CallableStatement stmt = null;
		try {
			conn=BaseDao.getConnection();
			stmt = conn.prepareCall("{call pro_owner_add2(?,?,?,?,?,?)}");
			stmt.setString(1, owner.getName());
			stmt.setLong(2, owner.getAddress());
			stmt.setString(3, owner.getHousenumber());
			stmt.setString(4, owner.getWatermeter());
			stmt.setLong(5, owner.getOwnertypeid());
			//ע�ᴫ������������
			stmt.registerOutParameter(6, OracleTypes.NUMBER);
			stmt.execute();
			//ִ�к�ȡ����������
			id = stmt.getLong(6);
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			BaseDao.closeAll(null, stmt, conn);
		}
		return id;
	}
}

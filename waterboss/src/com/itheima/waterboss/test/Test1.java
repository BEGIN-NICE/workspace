package com.itheima.waterboss.test;

import java.util.Date;

import org.junit.Test;

import com.itheima.waterboss.dao.OwnerProDao;
import com.itheima.waterboss.dao.OwnersDao;
import com.itheima.waterboss.entity.Owners;

public class Test1 {
	@Test
	public void addTest() {
		Owners owners = new Owners();
		owners.setId(11L);
		owners.setName("��ǿ");
		owners.setAddress(1l);
		owners.setHousenumber("2-2");
		owners.setWatermeter("3456");
		owners.setAdddate(new Date());
		owners.setOwnertypeid(1L);
		
		OwnersDao.add(owners);
	}
	
	@Test
	public void updateTest() {
		Owners owners = new Owners();
		owners.setId(11L);
		owners.setName("��ǿ");
		owners.setAddress(1l);
		owners.setHousenumber("5555");
		owners.setWatermeter("3456");
		owners.setAdddate(new Date());
		owners.setOwnertypeid(1L);
		
		OwnersDao.update(owners);
	}
	
	@Test
	public void deleteTest() {
		Owners owners = new Owners();
		owners.setId(11L);
		
		OwnersDao.delete(owners);
	}
	
	/**
	 * �޴��������Ĵ洢���̵�ʹ��
	 */
	@Test
	public void proTest() {
		Owners owners = new Owners();
		owners.setName("����Сǿ");
		owners.setAddress(1l);
		owners.setHousenumber("5558");
		owners.setWatermeter("3459");
		owners.setOwnertypeid(1L);
		
		OwnerProDao.add(owners);
	}
	/**
	 * �д��������Ĵ洢���̵�ʹ��
	 */
	@Test
	public void proTest2() {
		Owners owners = new Owners();
		owners.setName("����Сǿ2");
		owners.setAddress(1l);
		owners.setHousenumber("5558");
		owners.setWatermeter("34594");
		owners.setOwnertypeid(1L);
		
		Long id = OwnerProDao.add2(owners);
		System.out.println("�洢���̴����Ĳ����ǣ� "+id);
	}
}

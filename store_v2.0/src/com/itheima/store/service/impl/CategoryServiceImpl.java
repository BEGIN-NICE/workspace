package com.itheima.store.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.itheima.store.dao.CategoryDao;
import com.itheima.store.dao.impl.CategoryDaoImpl;
import com.itheima.store.domain.Category;
import com.itheima.store.service.CategoryService;
import com.itheima.store.utils.BeanFactory;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class CategoryServiceImpl implements CategoryService {

	/**
	 * ��ѯ��Ʒ����
	 */
	@Override
	public List<Category> findAll() throws SQLException {
		//��ȡ�����ļ�
		CacheManager cacheManager = CacheManager.create(CategoryServiceImpl.class.getClassLoader().getResourceAsStream("ehcache.xml"));
		//�������ļ��л�ȡ����ΪcategoryCache������
		Cache cache = cacheManager.getCache("categoryCache");
		//�жϻ������Ƿ���list����
		Element element = cache.get("list");
		List<Category> list = null;
		if(element == null) {
			CategoryDao categoryDao = (CategoryDaoImpl)BeanFactory.getBean("categoryDaoImpl");
			list = categoryDao.findAll();
			element = new Element("list", list);
			cache.put(element);
		}else {
			list = (List<Category>) element.getObjectValue();
		}
		return list;
	}

}

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
	 * 查询商品分类
	 */
	@Override
	public List<Category> findAll() throws SQLException {
		//读取配置文件
		CacheManager cacheManager = CacheManager.create(CategoryServiceImpl.class.getClassLoader().getResourceAsStream("ehcache.xml"));
		//从配置文件中获取名称为categoryCache缓存区
		Cache cache = cacheManager.getCache("categoryCache");
		//判断缓存中是否有list集合
		Element element = cache.get("list");
		List<Category> list = null;
		if(element == null) {
			CategoryDao categoryDao = (CategoryDaoImpl)BeanFactory.getBean("categoryDaoImpl");
			list = categoryDao.findAll();
			//将数据放入缓存
			element = new Element("list", list);
			cache.put(element);
		}else {
			list = (List<Category>) element.getObjectValue();
		}
		return list;
	}

	@Override
	public void save(Category category) throws SQLException {
		CategoryDao categoryDao = (CategoryDaoImpl)BeanFactory.getBean("categoryDaoImpl");
		categoryDao.save(category);
	}

	@Override
	public Category findByCid(String cid) throws SQLException {
		CategoryDao categoryDao = (CategoryDaoImpl)BeanFactory.getBean("categoryDaoImpl");
		
		return categoryDao.findByCid(cid);
	}

	@Override
	public void update(Category category) throws SQLException {
		CategoryDao categoryDao = (CategoryDaoImpl)BeanFactory.getBean("categoryDaoImpl");
		categoryDao.update(category);
	}

	@Override
	public void deleteByCid(String cid) throws SQLException {
		CategoryDao categoryDao = (CategoryDaoImpl)BeanFactory.getBean("categoryDaoImpl");
		categoryDao.deleteByCid(cid);
	}

	@Override
	public Category findByCname(String cname) throws SQLException {
		CategoryDao categoryDao = (CategoryDaoImpl)BeanFactory.getBean("categoryDaoImpl");
		return categoryDao.findByCname(cname);
	}

}

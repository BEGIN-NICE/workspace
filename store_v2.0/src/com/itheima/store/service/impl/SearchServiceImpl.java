package com.itheima.store.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.itheima.store.dao.ProductDao;
import com.itheima.store.dao.SearchDao;
import com.itheima.store.dao.impl.ProductDaoImpl;
import com.itheima.store.domain.PageBean;
import com.itheima.store.domain.Product;
import com.itheima.store.service.SearchService;
import com.itheima.store.utils.BeanFactory;

public class SearchServiceImpl implements SearchService {

	@Override
	public PageBean findByPname(String search,int currpage) throws SQLException {
		
		PageBean pageBean = new PageBean();
		//��ǰҳ
		pageBean.setCurrPage(currpage);
		//ÿҳ��������
		int pageSize = 12;
		pageBean.setPageSize(pageSize);
		//ÿҳ��Ʒ����
		SearchDao searchDao = (SearchDao) BeanFactory.getBean("searchDao");
		List<Product> list = searchDao.findByPname(search);
		pageBean.setList(list);
		//����������
		int count = searchDao.findCountByPname(search);
		pageBean.setTotalCount(count);
		//��ҳ��
		Double ceil = Math.ceil((double)count/pageSize);
		pageBean.setTotalPage(ceil.intValue());
		
		return pageBean;
	}


}

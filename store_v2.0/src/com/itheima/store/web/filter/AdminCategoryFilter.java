package com.itheima.store.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.itheima.store.service.CategoryService;
import com.itheima.store.utils.BeanFactory;
import com.itheima.store.web.servlet.AdminCategoryServlet;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;

/**
 * 过滤对category表进行就该后，使得前台数据同步，拦截清除ehcache
 * 中的缓存
 */
public class AdminCategoryFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		CacheManager cacheManager = CacheManager.create(AdminCategoryServlet.class.getClassLoader().getResourceAsStream("ehcache.xml"));
		Ehcache ehcache = cacheManager.getEhcache("categoryCache");
		ehcache.remove("list");
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}

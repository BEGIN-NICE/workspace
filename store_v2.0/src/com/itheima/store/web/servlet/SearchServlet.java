package com.itheima.store.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.store.domain.PageBean;
import com.itheima.store.domain.Product;
import com.itheima.store.service.SearchService;
import com.itheima.store.utils.BeanFactory;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    public String search(HttpServletRequest request,HttpServletResponse response) {
    	try{
    		String search = request.getParameter("search");
    		String currpagestr = request.getParameter("currpage");
    		int currpage;
    		if(currpagestr==null) {
    			currpage = 1;
    		}else {
    			currpage = Integer.parseInt(currpagestr);
    		}
	    	SearchService searchService = (SearchService) BeanFactory.getBean("searchService");
	    	PageBean pageBean = searchService.findByPname(search,currpage);
	    	request.setAttribute("pageBean", pageBean);
	    	return "/store/search_list.jsp";
    	}catch(Exception e) {
    		e.printStackTrace();
    		throw new RuntimeException();
    	}
    	
    }
}

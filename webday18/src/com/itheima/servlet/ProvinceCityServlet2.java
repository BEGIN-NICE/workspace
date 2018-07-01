package com.itheima.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.City;
import com.itheima.domain.Province;
import com.itheima.service.PCService;
import com.thoughtworks.xstream.XStream;

/**
 * Servlet implementation class ProvinceCityServlet2
 */
public class ProvinceCityServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProvinceCityServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String data = request.getParameter("data");
			PCService pcService = new PCService();
			List<Province> list = pcService.findProvince();
			request.setAttribute("list",list);
			if("xml".equals(data)) {
				request.getRequestDispatcher("/ajax_provincetocity2/province_city.jsp").forward(request, response);	
			}else {
				request.getRequestDispatcher("/ajax_provincetocity_json2/province_city.jsp").forward(request, response);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

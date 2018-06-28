package com.itheima.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.City;
import com.itheima.service.PCService;
import com.thoughtworks.xstream.XStream;

/**
 * Servlet implementation class CityServlet2
 */
public class CityServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CityServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String pid = request.getParameter("pid");
			PCService pcService = new PCService();
			List<City> list = pcService.findCityBypId(pid);
			
			XStream xStream = new XStream();
			xStream.alias("city", City.class);
			xStream.useAttributeFor(City.class, "cid");
			xStream.useAttributeFor(City.class, "city");
			xStream.useAttributeFor(City.class, "pid");
			String xmlStr = xStream.toXML(list);
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(xmlStr);
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

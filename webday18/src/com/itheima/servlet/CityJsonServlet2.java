package com.itheima.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.City;
import com.itheima.service.PCService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * Servlet implementation class CityJsonServlet2
 */
public class CityJsonServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CityJsonServlet2() {
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
			JsonConfig jsonConfig = new JsonConfig();
			
			JSONArray jsonArray = JSONArray.fromObject(list);
			
			jsonConfig.setExcludes(new String[] {"pid"});
			JSONArray jsonArray2 = JSONArray.fromObject(list,jsonConfig);
			System.out.println(jsonArray2);
			
			Map<String,List<City>> map = new HashMap<>();
			map.put("citys", list);
			map.put("citys2", list);
		
			JSONObject mapJson = JSONObject.fromObject(map);
			System.out.println(mapJson);
			
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(jsonArray);
			
		}catch(Exception e) {
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

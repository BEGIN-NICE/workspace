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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * Servlet implementation class CityJsonServlet
 */
public class CityJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String pid = request.getParameter("pid");
			PCService pcService = new PCService();
			List<City> list = pcService.findCityBypId(pid);
			
			//指定json数据中不包含某些数据
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setExcludes(new String[] {"pid","cid"});
			JSONArray jsonArray2 = JSONArray.fromObject(list, jsonConfig);
			
			System.out.println(jsonArray2);
			//将list集合转成json文件
			JSONArray jsonArray = JSONArray.fromObject(list);
			JSONObject jsonObject = JSONObject.fromObject(list.get(0));
			System.out.println(jsonObject);
			System.out.println(jsonArray);
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(jsonArray.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

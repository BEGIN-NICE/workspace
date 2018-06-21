<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>商品结算</h2>
	<%
		Map<String,Integer> map = (Map)request.getSession().getAttribute("cart");
		if(map==null){
	%>
		<h3>购物车中没有商品</h3>
	<% 
		}else{
			Set<String> keys = map.keySet();
			for(String key:keys){
				int count = map.get(key);
				%>
				<h3>要购买的商品名是：<%=key %>&nbsp;&nbsp;购买的数量是：<%=count %></h3><br>
				<% 
			}
		}
	%>
</body>
</html>
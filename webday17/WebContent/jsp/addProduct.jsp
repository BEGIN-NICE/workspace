<%@page import="com.itheima.utils.UUIDUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>添加商品界面</h1>
<%
	String id = UUIDUtil.getUUID();
	session.setAttribute("token",id);
%>
<form action="${pageContext.request.contextPath }/ProductAddServlet" method="post">
<input type="hidden" name="token" value="${token }">
<table border="1" width="500">
	<tr>
		<td>商品名称</td>
		<td><input type="text" name="pname"></td>
	</tr>
	<tr>
		<td>市场价格</td>
		<td><input type="text" name="market_price"></td>
	</tr>
	<tr>
		<td>商城名称</td>
		<td><input type="text" name="shop_price"></td>
	</tr>
	<tr>
		<td>是否热门</td>
		<td><input type="radio" name="is_hot" value="1" checked="checked">是<input type="radio" name="is_hot" value="0">否</td>
	</tr>
	<tr>
		<td>是否下架</td>
		<td>
			<select name="pflag">
					<option value="0">是</option>
					<option value="1">否</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>商品分类</td>
		<td>
			<select name="cid">
					<option value="1">手机数码</option>
					<option value="2">电脑办公</option>
					<option value="3">鞋靴箱包</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>商品描述</td>
		<td><textarea name="pdesc"></textarea></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="添加"></td>
	</tr>
</table>
</form>
</body>
</html>
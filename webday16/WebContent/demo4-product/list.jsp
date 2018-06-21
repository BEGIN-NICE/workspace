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
<h1>商品列表页面</h1>
<table border="1" width="100%">
	<tr>
		<td>商品编号</td>
		<td>商品名称</td>
		<td>商品价格</td>
		<td>是否热门</td>
		<td>商品描述</td>
		<td>商品图片</td>
	</tr>
	
<c:forEach var="pro" items="${list }">
	<tr>
		<td>${pro.pid }</td>
		<td>${pro.pname }</td>
		<td>${pro.market_price }</td>
		<td>
			<c:if test="${pro[is_hot] == 1 }">
				是
			</c:if>
			<c:if test="${pro[is_hot] != 1 }">
				否
			</c:if>
		</td>
		<td>${pro.pdesc }</td>
		<td><img src="${pageContext.request.contextPath }/${pro.pimage}"></td>
	</tr>
</c:forEach>
</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/ajax_provincetocity/pc.js"></script>

</head>
<body>
	<h2>省市二级联动</h2>
	省份：<select id="province" name="province">
	<option value="">请选择</option>
	<c:forEach var="p" items="${list }">
		<option value="${p.pid }">${p.province }</option>
	</c:forEach>
		
	</select>&nbsp;&nbsp;&nbsp;
	所在市:<select id="city" name="city">
		<option value="">请选择</option>
	</select>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	#div1{
		display:none;
		border: 1px solid;
		margin-right: auto;
		margin-left: auto; 
	}
	#span1{
		margin-right: auto;
		margin-left: auto;
	}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/ajax_word/ajax_info.js"></script>
<title>Insert title here</title>
</head>
<body>
<center>
<table>
	<tr>
		<td><h2 align="center">黑马一下你就知道</h2></td>
	</tr>
	<tr>
		<td><input type="text" id="search" name="search" value="${info }" style="width: 400px;height: 25px;"></td>
		<td><input type="button" value="黑马一下"></td>
	</tr>
	<tr>
		<td><div id="div1"></div></td>
	</tr>
</table>
</center>
</body>
</html>
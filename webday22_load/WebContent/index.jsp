<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	h1{
		color: white;
	}
	a{
		size: 40px;	
		color:white;
	}
</style>
</head>
<body background="${pageContext.request.contextPath }/img/index_bg.jpg">
<center>
	<h1>欢迎来到黑马社区</h1>
	<a>预览</a><br/>
	<a href="${pageContext.request.contextPath }/register.jsp">注册</a><br/>
	<a href="${pageContext.request.contextPath }/login.jsp">登录</a>
	
</center>	
</body>
</html>
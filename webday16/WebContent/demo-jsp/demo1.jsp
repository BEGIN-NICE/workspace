<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>演示jsp的注释</h1>
	
	<!-- html的注释  ；存在于HTML源代码中，存在于jsp源代码中，存在于翻译后的Servlet的Java代码中。-->
	
	<%
		//单行注释  ；存在于jsp源代码中，存在于翻译后的Servlet的Java代码中。
		
		/*
		多行注释
		*/
	
		/**
		*文档注释
		*/
		
	%>
	
	<%-- jsp的注释 ；只会存在于JSP源代码中，翻译成servlet后，注释消失。 --%>
	
	<h1>jsp中的Java代码块用HTML的注释是注释不掉的，必须用Java的注释或者jsp的注释。</h1>
</body>
</html>
<%@page import="com.itheima.domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	User user = new User();
	user.setUsername(username);
	user.setPassword(password);
%>
<%=user.toString() %>
<hr>
<jsp:useBean id="user1" class="com.itheima.domain.User" scope="page"></jsp:useBean>
<%-- <jsp:setProperty property="username" name="user1"/>
<jsp:setProperty property="password" name="user1"/> --%>


<jsp:setProperty property="*" name="user1"/>


<jsp:getProperty property="username" name="user1"/>
<jsp:getProperty property="password" name="user1"/>

</body>
</html>
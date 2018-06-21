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
	//pageContext.setAttribute("name", "pname",pageContext.PAGE_SCOPE);
	pageContext.setAttribute("name", "rname", pageContext.REQUEST_SCOPE);
	pageContext.setAttribute("name", "sname", pageContext.SESSION_SCOPE);
	pageContext.setAttribute("name", "aname", pageContext.APPLICATION_SCOPE);	
%>
<%=
pageContext.findAttribute("name")
%>
</body>
</html>
<%@page import="java.util.Enumeration"%>
<%@page import="com.itheima.sessionlistener.JavaBean1"%>
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
		JavaBean1 bean1 = new JavaBean1();
		session.setAttribute("bean1", bean1);
		Enumeration<String> en = request.getAttributeNames();
		while(en.hasMoreElements()){
			%>
			<%=en.nextElement()%>
			<%
		}
	%>
	${bean1.name }
	${bean2.name }

	
	
</body>
</html>
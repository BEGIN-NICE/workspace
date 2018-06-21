<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
<h1>JSTL常用标签：forEach</h1>
<h2>遍历数组</h2>
<%
	String[] arrs = {"fanxh","小明","小花"};
	pageContext.setAttribute("arrs", arrs);
%>
<%-- <c:set var="arrs" value=arrs scope="page"></c:set> --%>
<c:forEach var="i" items="${arrs }">
	${i }
</c:forEach>
<hr/>

<h2>遍历List集合</h2>
<%
	List<String> list = new ArrayList<>();
	list.add("fanxh");
	list.add("小明");
	list.add("小花");
	pageContext.setAttribute("list", list);
%>
<%-- <c:set var="arrs" value=arrs scope="page"></c:set> --%>
<c:forEach var="i" items="${list }">
	${i }
</c:forEach>
<hr/>

<h2>遍历Map集合</h2>
<%
	Map<String,String> map = new HashMap<>();
	map.put("aa", "fanxh");
	map.put("bb", "小明");
	map.put("cc", "小花");
	pageContext.setAttribute("map", map);
%>
<%-- <c:set var="arrs" value=arrs scope="page"></c:set> --%>
<c:forEach var="entry" items="${map }">
	${entry.key } -- ${entry.value }<br/>
</c:forEach>
<hr/>
<h2>遍历从1到10</h2>
<c:forEach var="i" begin="0" end="10">
${i }
</c:forEach>

<hr/>
<h2>遍历从1到50</h2>
<c:forEach var="i" begin="1" end="50" step="2" varStatus="status">
	<c:if test="${status.count % 3 == 0 }">
		<font color="red">${i }</font>
	</c:if>
	<c:if test="${status.count % 3 !=0 }">
	${i }
	</c:if>
</c:forEach>

</body>
</html>
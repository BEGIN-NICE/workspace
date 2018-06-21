<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
	<h1>EL表达式 一，获取数据</h1>
	<h2>EL表达式获取四个域中的值</h2>
	<%
		pageContext.setAttribute("name", "pname");
		request.setAttribute("name", "rname");
		session.setAttribute("name", "sname");
		application.setAttribute("name", "aname");
	%>
	${pageScope.name}
	<br> ${name }
	<hr>

	<h2>EL表达式获取数组中的值</h2>
	<%
		String[] arrs = { "fanxh", "小明", "小花" };
		pageContext.setAttribute("arrs", arrs);
	%>
	${arrs[0]}
	<br> ${arrs[1]}
	<br> ${arrs[2]}
	<br>
	<hr>
	
		<h2>EL表达式获取集合中的值</h2>
	<%
		List<String> list = new ArrayList<>();
		
		list.addAll(Arrays.asList(arrs));
		pageContext.setAttribute("list", list);
	%>
	${list[0]}
	<br> ${list[1]}
	<br> ${list[2]}
	<br>
	<hr>

			<h2>EL表达式获取Map集合中的值</h2>
	<%
		Map<String,String> map = new HashMap<>();
		map.put("aa", "fanxh");
		map.put("bb", "小明");
		map.put("cc", "小花");
		
		pageContext.setAttribute("map", map);
	%>
	${map.aa}
	<br> ${map.bb}
	<br> ${map.cc}
	<br>
	<hr>

	<h2>EL表达式获取对象中的属性值</h2>
	<%
		User u = new User(1, "fanxh", "123");
		pageContext.setAttribute("user", u);
	%>
	${user.id}
	<br> ${user.username}
	<br> ${user.password}
	<br>
	<hr>
====================================================
<h1>EL表达式 二，执行运算</h1>
<h3>执行算术运算</h3>
<%
	pageContext.setAttribute("n1", 10);
	pageContext.setAttribute("n2", 10);
	pageContext.setAttribute("n3", 30);
	pageContext.setAttribute("n4", 40);
%>
${n1+n2 }
<hr/>
<h3>执行逻辑运算</h3>
${n1 < n2 } --${n1 lt n2 } <!-- less than --><br>
${n1 > n2 } --${n1 gt n2 }<!-- great than --><br>

<hr/>
<h3>执行关系运算</h3>
${n1 == n2 && n3 < n4 } <br>
${n1 < n2 || n3 < n4 } <br>
${!(n1<n2) } - ${not(n1<n2) }

<hr/>
<h3>执行三元运算</h3>
${n1 == n2?true:false } <br>

<hr/>
<h3>empty运算</h3>
${user == null } - ${empty user } <br>
${user != null } - ${not empty user } <br>


</body>
</html>
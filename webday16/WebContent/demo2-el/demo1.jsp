<%@page import="com.itheima.domain.User"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL表达式获取数据</h1>
	<%
		//pageContext.setAttribute("name", "pvalue");
		request.setAttribute("name", "rvalue");
		session.setAttribute("name", "svalue");
		application.setAttribute("name", "avalue");	
	%>
	<hr/>
	<h2>通过对用域对象getAttribute获取对应域中的值</h2>
	<%=pageContext.getAttribute("name") %>  <!-- 如果没有找到返回的是 null,容易引发空指针异常 -->
	<%=request.getAttribute("name") %>
	<%=session.getAttribute("name") %>
	<%=application.getAttribute("name") %>
	<hr/>
<h2>通过EL表达式获取四个域中的值</h2>
	
	${pageScope.name }               <!-- 如果没有找到返回的是 "",不会引发空指针问题 -->
	${requestScope.name }
	${sessionScope.name }
	${applicationScope.name } 
	
	
	<h2>通过EL表达式获取数组数据</h2>
	<%
		String[] str = {"fanxh","雷子","阿花","小明"};
		pageContext.setAttribute("strs", str);
	%>
	${strs[0] }
	${strs[1] }
	${strs[2] }
	${strs[3] }
	
	<hr/>
	<h2>通过EL表达式获取集合数据</h2>
	<%
		List<String> list = new ArrayList<String>();
		list.add("fanxh");
		list.add("雷子");
		list.add("阿花");
		list.add("小明");
	pageContext.setAttribute("lists", list);	
	%>
	${lists[0] }
	${lists[1] }
	${lists[2] }
	${lists[3] }
	
		<hr/>
	<h2>通过EL表达式获取Map集合数据</h2>
	<%
		Map<String,String> map = new HashMap<String,String>();
		map.put("aa", "fanxh");
		map.put("bb", "雷子");
		map.put("cc", "阿花");
		map.put("dd", "小明");
	pageContext.setAttribute("map", map);	
	%>
	${map.aa }
	${map.bb }
	${map.cc }
	${map.dd }
	
		<hr/>
	<h2>通过EL表达式获取对象数据</h2>
	<%
		User user = new User(0,"fanxh","123");	
		pageContext.setAttribute("User", user);
	%>
	${User.id }
	${User.username }
	${User.password }
	
		<hr/>
	<h2>通过EL表达式获取对象的集合数据</h2>
	<%
	User user1 = new User(1,"fanxh1","123");	
	User user2 = new User(2,"fanxh2","123");	
	User user3 = new User(3,"fanxh3","123");	

	List<User> listUser = new ArrayList<User>();
		listUser.add(user);
		listUser.add(user1);
		listUser.add(user2);
		listUser.add(user3);
	pageContext.setAttribute("listUser", listUser);	
	%>
	${listUser[0].id }--${listUser[0].username }--${listUser[0].password }<br/>
	${listUser[1].id }--${listUser[1].username }--${listUser[1].password }<br/>
	${listUser[2].id }--${listUser[2].username }--${listUser[2].password }<br/>
	${listUser[3].id }--${listUser[3].username }--${listUser[3].password }<br/>
</body>
</html>
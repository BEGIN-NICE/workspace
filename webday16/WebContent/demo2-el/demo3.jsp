<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL功能三：操作web开发常用的对象  </h1>
	<!-- 
		pageScope,requestScope,sessionScope,applicationScope --获取jsp中域中的数据
	 	param,paramValues --接收参数
	 	header,heanderValue --获取请求头信息
	 	initParam --获取全局初始化参数
	 	cookie --web开发中的cookie
	 	pageContext --web开发中的pageContext
	 -->
	 <h3>获取配置的全局初始化参数</h3>
	 ${initParam.username }
	<hr/>
	<h3>获取请求头信息</h3>	 
	${header["User-Agent"] }
	<hr/>
	
	<%
		Cookie c = new Cookie("name","fanxh");
		response.addCookie(c);
	%>
	<h3>获取web开发中的cookie的值</h3>
	${cookie.name.value }
	<hr>
	<h3>获取web开发中的pageContext中的内容</h3>
	${pageContext.request.remoteAddr }<br>
	工程名： ${pageContext.request.contextPath }
</body>
</html>
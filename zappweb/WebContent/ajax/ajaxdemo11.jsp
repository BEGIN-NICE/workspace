<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
	.div1{
		border:1px solid;
		width: 400px;
		height: 400px
	}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/ajax/ajax.js"></script>

</head>
<body>
	<h1>AJAX完成get和post的异步请求</h1>
	
	<div id="div1" class="div1">
	
	</div>
	<input type="button" value="get方式" onclick="getMethod()">&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" value="post方式" onclick="postMethod()">&nbsp;&nbsp;&nbsp;&nbsp;
	<input id="jq_post" type="button" value="jq_post方式">&nbsp;&nbsp;&nbsp;&nbsp;
		<input id="jq_load" type="button" value="jq_load方式">
	<form action="" enctype="application/x-www-form-urlencoded"></form>
</body>
</html>
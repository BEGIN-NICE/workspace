<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#div1{
		width: 300px;
		height: 200px;
		border: 1px solid red;
	}
</style>

<script type="text/javascript" src="${pageContext.request.contextPath }/ajax/ajax.js"></script>
</head>
<body>
<h1>AJAX的get和post方式异步请求</h1>
<div id="div1" >


</div>
<input id="but1" type="button" value="get方式的ajax请求" onclick="ajax_get()"/>&nbsp;&nbsp;&nbsp;&nbsp;
<input id="but2" type="button" value="post方式的ajax请求" onclick="ajax_post()"/>
<form action="" enctype="application/x-www-form-urlencoded"></form>
</body>
</html>
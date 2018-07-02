<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript"></script>
<!-- <style type="text/css">
	#userdiv{
		width: 80%;
		height: 30px;
	}
	#titlediv{
		width: 80%;

	}
	#detailsdiv{
		width: 80%;
	}
</style> -->
</head>
<body background="${pageContext.request.contextPath }/img/bg.jpg">
<center>
	<div id="userdiv">
		你好:${user.username }&nbsp;&nbsp;
		<img style="width: 100px; height: 100px;" src="${user.photouuid }"/>
		<a href="#">我的</a>&nbsp;&nbsp;
		<a href="#">退出</a>
	</div>
	<hr>
	<div id="titlediv">
		<h1>1111111</h1>
		<h1>1111111</h1>
		<h1>1111111</h1>
		<h1>1111111</h1>
		<h1>1111111</h1>
		<h1>1111111</h1>
		<h1>1111111</h1>
		<h1>1111111</h1>
	</div>
	<div id="detailsdiv">
		<h1>1111111</h1>
	</div>
</center>	
</body>
</html>
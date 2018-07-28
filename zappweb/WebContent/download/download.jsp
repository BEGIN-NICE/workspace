<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h3>超链接下载</h3>
	<a href="a.txt">下载</a><!-- 文件相对于该jsp界面的路径 -->
		<h3>html实现下载</h3>
	<a href="${pageContext.request.contextPath }/FileDownLoadServlet?filename=a.txt">a.txt</a>
	
		<h3>代码实现下载</h3>
	<a href="${pageContext.request.contextPath }/FileDownLoadServlet?filename=a.txt">a.txt</a><br>
	<a href="${pageContext.request.contextPath }/FileDownLoadServlet?filename=zhouli.PNG">zhouli.PNG</a>

		<h3>中文乱码</h3>
	<a href="${pageContext.request.contextPath }/FileDownLoadServlet?filename=杨过.txt">杨过.txt</a><br>
	<a href="${pageContext.request.contextPath }/FileDownLoadServlet?filename=美女.jpg">美女.jpg</a>
	
	<h1>中文文件名解决下载乱码</h1>
	<a href="${pageContext.request.contextPath }/FileDownLoadServlet2?method=demo1&filename=美女.jpg">美女.jpg</a>
	
</body>
</html>
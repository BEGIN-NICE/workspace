<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>文件上传</h1>
	<a href="${pageContext.request.contextPath }/upload.jsp">单个文件上传</a><br>
	<a href="${pageContext.request.contextPath }/uploadmany.jsp">多个个文件上传</a><br>
<h1>ajax和json</h1>
	<a href="${pageContext.request.contextPath }/login.jsp">用户名异步校验</a><br>
	<a href="${pageContext.request.contextPath }/product.jsp">商品展示</a><br>
<h1>小练习</h1>
	<a href="${pageContext.request.contextPath }/login2.jsp">登录后方可查看商品</a><br>	
	<a href="${pageContext.request.contextPath }/showproduct.jsp">登录后方可查看商品</a>	
</body>
</html>
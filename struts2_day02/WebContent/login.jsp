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
	valuestack:&nbsp;&nbsp;&nbsp;<s:property value="loginmsg"/><hr>
	actionError:&nbsp;&nbsp;&nbsp;<s:actionerror/><hr>
	fieldError:&nbsp;&nbsp;&nbsp;<s:fielderror/><hr>
	actionMessage:&nbsp;&nbsp;&nbsp;<s:actionmessage/><hr>
	<form action="${pageContext.request.contextPath }/login.action" mehtod="post">
		姓名:<input type="text" name="username"><br>
		密码:<input type="password" name="password"><br>
		<input type="submit" value="login">
	</form>
</body>
</html>
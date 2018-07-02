<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body background="${pageContext.request.contextPath }/img/bg.jpg">
<center>
<h1>用户登录</h1>
	<table>
		<form action="${pageContext.request.contextPath }/LoginServlet" method="post" >
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="username" ><span>${login_error }</span></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input type="text" name="password" ></td>
			</tr>
			<tr>
				
				<td><input type="checkbox" name="autologin" value="true"></td>
				<td>自动登录</td>
			</tr>
			<tr>
				<td><input type="submit" value="login"></td>
			</tr>
		</form>
	</table>
</center>	
</body>
</html>
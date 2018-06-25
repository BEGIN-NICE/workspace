<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>用户注册页面</h1>
<form action="${pageContext.request.contextPath }/jsp_javabean/demo1.jsp" method="post">
	<table>
		<tr>
			<td>用户名</td>
			<td><input id="username" type="text"  name="username" value="${username }" onblur="checkUsername()">
				<span id="s1"></span>
			</td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input id="password" type="text" name="password" value="${password }" onblur="checkPassword()">
				<span id="s2"></span>
			</td>
		</tr>
			<td><input id="sub" type="submit" value="注册"></td>
		</tr>
	</table>
</form>
</center>
</body>
</html>
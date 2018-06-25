<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/ajax_jq_login/jq_login.js"></script>
</head>
<body>
<center>
<h1>用户注册页面</h1>
<form action="" method="post">
	<table>
		<tr>
			<td>用户名</td>
			<td><input id="username" type="text"  name="username" value="${username }"  >
				<span id="s1"></span>
			</td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input id="password" type="text" name="password" value="${password }" >
				<span id="s2"></span>
			</td>
		</tr>
		<tr>
			<td>昵称</td>
			<td><input id="nickname" type="text" name="nickname" value="${nickname }">
				<span id="s3"></span>
			</td>
		</tr>
		<tr>
			<td>类型</td>
			<td><input id="type" type="radio" name="type" value="user">用户
				<input id="type" type="radio" name="type" value="root">管理员
			</td>
		</tr>
		<tr>
			<td><input id="sub" type="submit" value="注册"></td>
		</tr>
	</table>
</form>
</center>
</body>
</html>
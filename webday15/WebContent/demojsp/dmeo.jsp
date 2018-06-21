<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h2>my first jsp</h2>
	
	<table style="border: 1px solid red; width: 800px;height: 600px">
	
		<% 
			for(int i=0;i<10;i++){
		%>
		<tr>
			<% 
				for(int j=0;j<10;j++){
			%>
			<td style="border: 1px solid red;">表格</td>
			<%} %>
		</tr>
		<%} %>
	</table>
	
</body>
</html>
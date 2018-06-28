<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function infolist(str){
		document.getElementById("innerInfo").value=str.innerHTML;
		str.style.background="green";
	}
	function infolistout(str){
		str.style.background="white";
	}

</script>
</head>
<body>
<table>
	<c:forEach var="info" items="${list }">
	<tr>
		<td id = "infolist" onmouseout="infolistout(this)" onmouseover="infolist(this)" style="width: 100%">${info }</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>
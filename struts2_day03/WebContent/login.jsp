<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function(){
		$("#username").blur(function(){
			var $val = $("#username").val();
			$.post("${pageContext.request.contextPath}/checkUsername",{"username":$val},function(data){
				data = JSON.parse(data);
				if(data.flag){
					$("#span1").html("<font color='green'>"+data.message+"</font>")
				}else{
					$("#span1").html("<font color='red'>"+data.message+"</font>")
					
				}
			});
		})
		
	})

</script>
</head>
<body>
	<form action="#" mehtod="post">
		姓名:<input id="username" type="text" name="username"><span id="span1"></span><br>
		密码:<input type="password" name="password"><br>
		<input type="submit" value="login">
	</form>
</body>
</html>
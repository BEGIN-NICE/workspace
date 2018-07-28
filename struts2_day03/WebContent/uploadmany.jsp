<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/uploadmany" method="post" enctype="multipart/form-data">
		选择文件:<input type="file" name="upload"><br>
		选择文件:<input type="file" name="upload"><br>
		选择文件:<input type="file" name="upload"><br>
			  <input type="submit" value="上传"><br>
	</form>
	<s:debug/>
</body>
</html>